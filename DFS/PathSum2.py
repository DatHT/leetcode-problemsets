# https://leetcode.com/problems/path-sum-ii/description/
from typing import Optional, List
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        currentPath = []
        return self.findAllPath(root.val, targetSum, currentPath, result)
        

    def findAllPath(self, root, targetSum, currentPath, allPath):
        if root is None:
            return allPath
        currentPath.append(root.val)
        if root.left is None and root.right is None and root.val == targetSum:
            allPath.append(currentPath)
        else:
            self.findAllPath(root.left, targetSum - root.val, currentPath, allPath)
            self.findAllPath(root.right, targetSum - root.val, currentPath, allPath)
