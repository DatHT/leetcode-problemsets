package DFS

import BFS.TreeNode1
// https://leetcode.com/problems/validate-binary-search-tree/

class ValidateBST98 {
    fun isValidBST(root: TreeNode1?): Boolean {
        return dfs(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
    }

    private fun dfs(node: TreeNode1?, min_: Double, max_: Double): Boolean {
        // base case
        if (node == null) {
            return true
        }

        // check if the current node's value is within the valid range
        if (node.`val`.toDouble() <= min_ || node.`val`.toDouble() >= max_) {
            return false
        }

        return dfs(node.left, min_, node.`val`.toDouble()) && dfs(node.right, node.`val`.toDouble(), max_)
    }
}