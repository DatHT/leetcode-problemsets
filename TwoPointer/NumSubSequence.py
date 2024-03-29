# https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

from typing import List
class Solution:
    def numSubseq(self, nums: List[int], target: int) -> int:
        nums.sort()
        mod = 10 ** 9 + 7
        count = 0
        start, end = 0, len(nums) - 1
        prev_start, prev_end = -1, -1
        if nums[start] > target:
            return 0
        while start != end:
            if start != prev_start and nums[start] + nums[start] <= target:
                count += 1
            if end != prev_end and nums[end] + nums[end] <= target:
                count += 1
            sum_val = nums[start] + nums[end]
            prev_end = end
            prev_start = start
            if sum_val > target:
                end -= 1
            else:
                total = pow(2, end - start, mod)
                count += total - 1
                start += 1
            
        return count % mod
