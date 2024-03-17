# https://leetcode.com/problems/next-greater-element-i/description/
from typing import List
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # create  a stack to store the position of next greater
        stack = []
        # init the result is a dictionary
        # the purpose of dictionary is fastly to get an item from it
        result = {}
        # interate each element in num2
        for i in range(len(nums2)):
            # will have action when stack is not empty and last element of stack is less than current element in num2
            while stack and nums2[stack[-1]] < nums2[i]:
                curr = stack.pop()
                result[nums2[curr]] = nums2[i]
            stack.append(i)
        # now we have a dict that key is the value of item in num2 and value is the next greater value
        final_result = []
        for i in range(len(nums1)):
            if nums1[i] in result:
                final_result.append(result[nums1[i]])
            else:
                final_result.append(-1)
        return final_result

        