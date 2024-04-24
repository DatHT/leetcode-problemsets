# https://leetcode.com/problems/squares-of-a-sorted-array/description/
from typing import List
class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            result.append(nums[i] ** 2)
        result.sort()
        return result