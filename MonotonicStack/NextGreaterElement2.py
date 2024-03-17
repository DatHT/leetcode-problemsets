# https://leetcode.com/problems/next-greater-element-ii/
from typing import List

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # init result list has all elelemt is -1
        result = [-1] * len(nums)
        # init the stack for handling monotonic stack
        stack = []
        last_item = nums[len(nums) - 1]
        # remove last item in nums
        nums.pop()
        # insert last item into the first position of the list nums
        nums.insert(0, last_item)
        # interate each item in nums
        for i in range(len(nums)):
            while stack and nums[stack[-1]] < nums[i]:
                curr = stack.pop()
                result[curr] = i - 1
            stack.append(i)
        # we have a result that contain a pos of next greater element
        first_item = result[0]
        result.pop(0)
        result.append(first_item)
        # make nums become the original list
        first_item = nums[0]
        nums.pop(0)
        nums.append(first_item)
        return [item if item == -1 else nums[item] for item in result]


        
s = Solution()
print(s.nextGreaterElements([1,2,3,4,5]))