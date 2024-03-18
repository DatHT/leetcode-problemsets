# https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
from typing import Optional, List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        result = []
        if root is None:
            return result
        queue = [root]
        while queue:
            curr_lv = []
            for i in range(len(queue)):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                curr_lv.append(node.val)
            result.append(sum(curr_lv)/len(curr_lv))
        return result