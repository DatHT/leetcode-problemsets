# https://leetcode.com/problems/reverse-vowels-of-a-string/
class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = "aeiou"
        s = list(s)
        l,r = 0, len(s) - 1
        for i in range(len(s)):
            if (s[l].lower() in vowels):
                if (s[r].lower() in vowels):
                    s[l], s[r] = s[r], s[l]
                    l += 1
                    r -= 1
                else:
                    r -= 1
            else:
                if(s[r].lower() in vowels):
                    l += 1
                else:
                    l += 1
                    r -= 1
        return ''.join(s)
    
s = Solution()
print(s.reverseVowels("hello")) # "holle"