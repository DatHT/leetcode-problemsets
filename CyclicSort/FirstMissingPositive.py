class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        nums.sort()
        pos = 0
        for i in range(0, len(nums) - 1):
            if nums[i] <= 0 and nums[i + 1] > 0:
                pos = i + 1
        count = 1
        for i in range(pos, len(nums) - 1):
            if nums[i] != count:
                return count
            elif nums[i] == count and nums[i] != nums[i + 1]:
                count += 1
        if nums[len(nums) - 1] != count:
            return count
        else:
            return count + 1