package DFS

import BFS.TreeNode1
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

class GoodNode1448 {
    fun goodNodes(root: TreeNode1?): Int {
        if (root == null) return 0
        return findGoodNodes(root, root.`val`)
    }

    fun findGoodNodes(node: TreeNode1?, max: Int): Int {
        if (node == null) return 0
        var maxVal = max
        var count = 0
        if (node.`val` >= max) {
            maxVal = node.`val`
            count += 1
        }
        val left = findGoodNodes(node.left, maxVal)
        val right = findGoodNodes(node.right, maxVal)
        return left + right + count
    }
}