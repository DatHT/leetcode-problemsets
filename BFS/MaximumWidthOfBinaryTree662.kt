package BFS

import java.util.LinkedList
import java.util.Queue

// https://leetcode.com/problems/maximum-width-of-binary-tree/description/

class MaximumWidthOfBinaryTree662 {
    fun widthOfBinaryTree(root: TreeNode1?): Int {
        root?.let {
            val queue: Queue<Pair<TreeNode1, Long>> = LinkedList()
            queue.add(root to 0L)
            var result = 0L
            while (queue.isNotEmpty()) {
                val size = queue.size
                var minVal = Long.MAX_VALUE
                var maxVal = Long.MIN_VALUE
                for (i in 0..size - 1) {
                    val curr = queue.poll()
                    minVal = minOf(minVal, curr.second)
                    maxVal = maxOf(maxVal, curr.second)
                    curr.first.left?.let {
                        queue.add(it to curr.second * 2)
                    }
                    curr.first.right?.let {
                        queue.add(it to curr.second * 2 + 1)
                    }
                }
                if (minVal != Long.MAX_VALUE && maxVal != Long.MIN_VALUE) {
                    result = maxOf(result, maxVal - minVal + 1)
                }
            }
            return result.toInt()
        } ?: kotlin.run { return 0 }
    }


}

fun main() {
    val root = TreeNode1(1)
    root.left = TreeNode1(3)
    root.right = TreeNode1(2)
    root.left?.left = TreeNode1(5)
    root.left?.left?.left = TreeNode1(8)
    root.right?.right = TreeNode1(9)
    root.right?.right?.left = TreeNode1(7)
    val result = MaximumWidthOfBinaryTree662().widthOfBinaryTree(root)
    println(result)
}