# https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
class Solution:
    def findAnagrams_old(self, s: str, p: str):
        result = []
        if len(p) > len(s):
            return result
        fixed_window = s[0: len(p)]

        for i in range(len(s) - len(p) + 1):
            fixed_window = s[i: i + len(p)]
            if sorted(fixed_window) == sorted(p):
                result.append(i)
        return result
    def findAnagrams(self, s: str, p: str):
        from collections import defaultdict
        table = defaultdict(int)
        for c in p:
            table[c] += 1
        result = []
        counter = len(table)
        start, end, window_len = 0, 0, len(p)
        while end < len(s):
            end_char = s[end]
            if end_char in table:
                table[end_char] -= 1
                if table[end_char] == 0:
                    counter -= 1
            end += 1
            while counter == 0:
                if end - start == window_len:
                    result.append(start)
                start_char = s[start]
                if start_char in table:
                    table[start_char] += 1
                    if table[start_char] > 0:
                        counter += 1
                start += 1
        return result


if __name__ == "__main__":
    s = Solution()
    print(s.findAnagrams("abacbabc", "abc"))