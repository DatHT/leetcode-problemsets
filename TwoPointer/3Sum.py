# https://leetcode.com/problems/3sum/
from typing import List
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #-4 -1 -1 0 1 2
        nums.sort()
        result = []
        for left in range(len(nums)-2):
            if left > 0 and nums[left] == nums[left-1]:
                continue
            mid = left + 1
            right = len(nums) - 1

            while mid < right:
                summ = nums[left] + nums[mid] + nums[right]
                if summ < 0:
                    mid += 1
                elif summ > 0:
                    right -= 1
                else:
                    result.append([nums[left],nums[mid],nums[right]]) 
                    while mid < right and nums[mid] == nums[mid+1]:
                        mid+=1
                    while mid < right and nums[right] == nums[right-1]:
                        right -= 1

                    mid +=1
                    right -= 1
        return result


s = Solution()
print(s.threeSum([0,1,1]))  # Output: [[-1,-1,2],[-1,0,1]]