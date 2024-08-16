package BFS

//https://leetcode.com/problems/diameter-of-binary-tree/description/

class TreeNode1(var `val`: Int) {
    var left: TreeNode1? = null
    var right: TreeNode1? = null
}

class DiameterOfB {
    var result = 0
    fun diameterOfBinaryTree(root: TreeNode1?): Int {
        calDiameter(root)
        return result
    }

    private fun calDiameter(root: TreeNode1?) : Int {
        if (root == null) return 0
        val leftHeight = calDiameter(root.left)
        val rightHeight = calDiameter(root.right)
        result = maxOf(result, leftHeight + rightHeight)
        return 1 + maxOf(leftHeight, rightHeight)
    }
}

fun main() {
    val root = TreeNode1(1)
    root.left = TreeNode1(2)
    root.right = TreeNode1(3)
    root.left?.left = TreeNode1(4)
    root.left?.right = TreeNode1(5)
    val result = DiameterOfB().diameterOfBinaryTree(root)
    println(result)
}