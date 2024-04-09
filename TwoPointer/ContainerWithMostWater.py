# https://leetcode.com/problems/container-with-most-water/
from typing import List
class Solution:
    def maxArea(self, height: List[int]) -> int:
        result = 0
        l, r = 0, len(height) - 1
        while l <= r:
            result = max(result, (r - l) * min(height[l], height[r]))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return result
    

s = Solution()
print(s.maxArea([2,3,4,5,18,17,6]))