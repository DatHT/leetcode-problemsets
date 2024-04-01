# https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        max_res = 0
        left, right = 0, len(nums) - 1
        while left <= right:
            max_res = max(max_res, nums[left] + nums[right])
            left += 1
            right -= 1
        return max_res
        