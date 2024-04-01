# https://leetcode.com/problems/sum-of-square-numbers/


class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        if c == 1 or c == 2 or c == 0: return True
        left, right = 0, int(sqrt(c))

        while left <= right:
            sum = left ** 2 + right ** 2
            if sum > c:
                right -= 1
            elif sum < c:
                left += 1
            else:
                return True
        return False
        