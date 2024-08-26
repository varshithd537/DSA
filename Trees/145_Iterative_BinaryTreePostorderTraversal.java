//LeetCode URL - https://leetcode.com/problems/binary-tree-postorder-traversal/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //1 - Recursive Solution
    public List<Integer> postorderTraversal(TreeNode root) {
    // List<Integer> res = new LinkedList<>();
    //     postOrder(root, res);
    //     return res;
    // }

    // void postOrder(TreeNode root, List<Integer> list){
    //     if(root == null){
    //         return;
    //     }

    //     postOrder(root.left, list);
    //     postOrder(root.right, list);
    //     list.add(root.val);
    // }

    //2 - Iterative Solution?
        List<Integer> result = new ArrayList<>();

        // If the root is null, return an empty list
        if (root == null) {
            return result;
        }

        // To keep track of the previously processed node

        //Here, when you come back to root of a subtree/tree, how will you know you have visited right subtree already??
        //Track it with a temporary vairable of previous node??
        //before getting popped, store it as a previous node
        TreeNode previousNode = null;

        // Stack to manage the traversal
        Stack<TreeNode> traversalStack = new Stack<>();

        // Process nodes until both the root is null and the stack is empty
        while (root != null || !traversalStack.isEmpty()) {
            // Traverse to the leftmost node
            if (root != null) {
                traversalStack.push(root);
                root = root.left;
            } else {
                // Peek at the top node of the stack
                root = traversalStack.peek();

                // If there is no right child or the right child was already processed
                if (root.right == null || root.right == previousNode) {
                    result.add(root.val);
                    traversalStack.pop();
                    previousNode = root;
                    root = null; // Ensure we don’t traverse again from this node
                } else {
                    // Move to the right child
                    root = root.right;
                }
            }
        }

        return result;
    }

    //3 - Morris Traversal??
}
