# https://leetcode.com/problems/next-permutation/description/
from typing import List
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left_pos = -1
        found = False
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                left_pos = i - 1
                found = True
                break
        if not found:
            nums.reverse()
            return
        else:
            right_pos = len(nums) - 1
            while nums[left_pos] >= nums[right_pos]:
                right_pos -= 1
            # exange the position of left and right
            nums[left_pos], nums[right_pos] = nums[right_pos], nums[left_pos]
            # reverse the rest of the list from left
            nums[left_pos + 1:] = nums[left_pos + 1:][::-1]
        
        


s = Solution()
nums = [1,]
s.nextPermutation(nums)
print(nums)

# 1,2,3,4
# 1,2,4,3
# 1,3,2,4
# 1,3,4,2
# 1,4,2,3
# 1,4,3,2
# 2,1,3,4 ()
# 2,1,4,3
# 2,3,1,4
# 2,3,4,1
# 2,4,1,3
# 2,4,3,1
# 3,1,2,4
# 3,1,4,2
# 3,2,1,4
# 3,2,4,1
# 3,4,1,2
# 3,4,2,1
# 4,1,2,3 (if l = 0 and can not find number, then use max in nums for l = 0)

# 1,2,3,4,5
# 1,2,3,5,4
# 1,2,4,3,5  
# 1,2,4,5,3

