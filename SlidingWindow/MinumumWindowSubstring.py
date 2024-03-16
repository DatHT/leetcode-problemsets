# https://leetcode.com/problems/minimum-window-substring/description/
class Solution:
    def minWindow_final(self, s: str, t: str) -> str:
        from collections import defaultdict

        table = defaultdict(int)

        # initialize frequency table for t
        for c in t:
            table[c] += 1

        # initialize sliding window
        begin, end = 0, 0
        counter = len(table)
        len_window = float('inf')

        ans = ""

        # start sliding window
        while end < len(s):
            endchar = s[end]

            # if current char found in table, decrement count
            if endchar in table:
                table[endchar] -= 1
                if table[endchar] == 0:
                    counter -= 1

            end += 1

            # if counter == 0, means we found an answer, now try to trim that window by sliding begin to right.
            while counter == 0:
                # store new answer if smaller than previously best
                if end - begin < len_window:
                    len_window = end - begin
                    ans = s[begin:end]

                # begin char could be in table or not,
                # if not then good for us, it was a wasteful char and we shortened the previously found substring.

                # if found in table increment count in table, as we are leaving it out of window and moving ahead,
                # so it would no longer be a part of the substring marked by begin-end window
                # table only has count of chars required to make the present substring a valid candidate
                # if the count goes above zero means that the current window is missing one char to be an answer candidate
                startchar = s[begin]

                if startchar in table:
                    table[startchar] += 1
                    if table[startchar] > 0:
                        counter += 1

                begin += 1

        return ans
    
    def minWindow_correct(self, s: str, t: str):
        if len(t) > len(s):
            return ""
        if s == t:
            return s
        if len(t) == 1:
            if t in s:
                return t
            else:
                return ""
        table = {}
        for c in t:
            if c in table:
                table[c] += 1
            else:
                table[c] = 1
        copy_table = table.copy()
        start_point = 0
        iterator = 0
        current_window = ""
        result = s + "@"
        count = len(t)
        start = (0, False)
        while start_point < len(s):
            check_char = s[iterator]
            current_window += check_char
            
            if check_char in copy_table:
                if start[1] == False:
                    start = (iterator, True)
                copy_table[check_char] -= 1
                if copy_table[check_char] == 0:
                    del copy_table[check_char]
                count -= 1
            iterator += 1
            if count == 0:
                if len(current_window) < len(result):
                    result = current_window
                if start[0] == start_point:
                    start_point += 1
                else:
                    start_point = start[0]
                start = (0, False)
                iterator = start_point
                count = len(t)
                current_window = ""
                copy_table = table.copy()
            if iterator == len(s):
                if start[1] == False:
                    break
                if start[0] == start_point:
                    start_point += 1
                else:
                    start_point = start[0]
                start = (0, False)
                iterator = start_point
                count = len(t)
                current_window = ""
                copy_table = table.copy()
        if len(result) == len(s) + 1:
            return ""
        return result

if __name__ == "__main__":
    s = Solution()
    print(s.minWindow_final("abc", "ab")) # BANC
    


