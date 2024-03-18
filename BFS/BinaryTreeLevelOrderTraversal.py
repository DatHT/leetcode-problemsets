# https://leetcode.com/problems/binary-tree-level-order-traversal/description/

from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if root is None: 
            return result
        queue = [root]

        while queue:
            current_level = []
            for i in range(len(queue)):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                current_level.append(node.val)
            result.append(current_level)
        return result
    

s = Solution()  
print(s.levelOrder([3,9,20,None,None,15,7])) # [[3],[9,20],[15,7]]