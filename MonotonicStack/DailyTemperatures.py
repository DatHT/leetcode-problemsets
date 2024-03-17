from typing import List
def nextgreater(arr):
    stack = []
    result = [-1]*len(arr)
    for i in range(len(arr)):
        # while loop runs till stack is empty
        while stack and arr[stack[-1]] < arr[i]: # stack top is strictly smaller than current element
            curr = stack.pop() 
            result[curr] = i
        stack.append(i)
    return result
	
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # create a list  of result with init value is 0
        result = [0] * len(temperatures)
        # create a stack to handle monotonic stack
        stack = []
        # interate each item in temperatures
        for i in range(len(temperatures)):
            # check last item from stack is less than current item or not
            while stack and temperatures[stack[-1]] < temperatures[i]:
                # pop the top item in stack out
                curr = stack.pop()
                # update the position of greater item in current position
                result[curr] = i
            stack.append(i)
        # we have all greater item position in result
        # update result with different between current item and greater item
        for i in range(len(result)):
            if result[i] != 0:
                result[i] = result[i] - i
        return result