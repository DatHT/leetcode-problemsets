# https://leetcode.com/problems/valid-palindrome/description/
class Solution:
    def validPalindrome(self, s: str) -> bool:
        if len(s) <= 2:
            return True
        def verify(s, l, r, used):
            while l < r:
                if s[l] != s[r]:
                    if used:
                        return False
                    else:
                        return verify(s, l + 1, r, True) or verify(s, l, r - 1, True)
                else:
                    l += 1
                    r -= 1
            return True
        return verify(s, 0, len(s) - 1, False)
s = Solution()
print(s.validPalindrome("ebcbbececabbacecbbcbe")) # False