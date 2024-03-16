# https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
class Solution:
    def findSubstring(self, s: str, words: list[str]):
        from collections import defaultdict
        table = defaultdict(int)
        for word in words:
            table[word] += 1
        begin, end, counter = 0, 0, len(table)
        word_len = len(words[0])
        result = []
        while end < len(s):
            end_word = s[end: end + word_len]
            if end_word in table:
                table[end_word] -= 1
                if table[end_word] == 0:
                    counter -= 1
            end += 1
            while counter == 0:
                begin_word = s[begin: begin + word_len]
                if end + word_len - 1 - begin == word_len * len(words) and sorted(s[begin: end + word_len - 1]) == sorted("".join(words)):
                    result.append(begin)
                if begin_word in table:
                    table[begin_word] += 1
                    if table[begin_word] > 0:
                        counter += 1
                begin += 1
        if len(result) == 0:
            return [0]
        return result
        

if __name__ == "__main__":
    s = Solution()
    print(s.findSubstring("ababababab", ["ababa","babab"])) 
    