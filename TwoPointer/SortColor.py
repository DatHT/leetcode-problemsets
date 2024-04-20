from typing import List
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) <= 1:
            return nums
        else:
            pivot = nums[0]
            less_than_pivot =[x for x in nums[1:] if x <= pivot]
            greater_than_pivot = [x for x in nums[1:] if x > pivot]
            return self.sortColors(less_than_pivot) + [pivot] + self.sortColors(greater_than_pivot)
        
s = Solution()
nums = [2,0,2,1,1,0]
print(s.quickSort(nums))