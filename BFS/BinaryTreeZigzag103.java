package BFS;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class BinaryTreeZigzag103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        boolean isLeft = true;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            if (isLeft) {
                isLeft = false;
            } else {
                Collections.reverse(list);
                isLeft = true;
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
    }
}
