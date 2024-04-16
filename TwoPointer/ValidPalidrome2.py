# https://leetcode.com/problems/valid-palindrome-ii/description/

class Solution:
    def validPalindrome(self, s: str) -> bool:
        if len(s) <= 2:
            return True
        if s == s[::-1]:
            return True
        l, r = 0, len(s) - 1
        s = list(s)
        for i in range(len(s)):
            temp = s[:]
            temp[i] = ''
            confirm_str = ''.join(temp)
            if confirm_str == confirm_str[::-1]:
                return True
        return False
    
s = Solution()
print(s.validPalindrome("abc")) # False