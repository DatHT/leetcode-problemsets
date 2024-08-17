package DFS

import BFS.TreeNode1

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
class MaximumDepthOfBinaryTree104 {
    fun maxDepth(root: TreeNode1?): Int {
        if (root == null) return 0

        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        return maxOf(left, right) + 1
    }
}