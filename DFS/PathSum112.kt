package DFS

import BFS.TreeNode1

class PathSum112 {
    fun hasPathSum(root: TreeNode1?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) return root.`val` == targetSum
        val target = targetSum - root.`val`
        return hasPathSum(root.left, target) || hasPathSum(root.right, target)
    }
}

fun main() {
    val root = TreeNode1(5)
    root.left = TreeNode1(4)
    root.right = TreeNode1(8)
    root.left?.left = TreeNode1(11)
    root.left?.left?.left = TreeNode1(7)
    root.left?.left?.right = TreeNode1(2)
    root.right?.left = TreeNode1(13)
    root.right?.right = TreeNode1(4)
    root.right?.right?.right = TreeNode1(1)

    val pathSum112 = PathSum112()
    println(pathSum112.hasPathSum(root, 22)) // true
//    println(pathSum112.hasPathSum(root, 26)) // true
//    println(pathSum112.hasPathSum(root, 18)) // true
//    println(pathSum112.hasPathSum(root, 17)) // false
}