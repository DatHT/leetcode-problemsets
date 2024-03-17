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
	