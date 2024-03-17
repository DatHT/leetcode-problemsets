# https://leetcode.com/problems/largest-rectangle-in-histogram/description/
from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:

        heights.append(0)
        stack = [-1]
        result = 0

        for i in range(len(heights)):
            while stack and heights[stack[-1]] > heights[i]:
                curr = stack.pop()
                width = i - stack[-1] -1
                result = max(result, width * heights[curr])
            stack.append(i)
        return result
    
s = Solution()
print(s.largestRectangleArea([2,1,5,6,2,3])) # 10