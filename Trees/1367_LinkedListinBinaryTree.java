//Leetcode URL - https://leetcode.com/problems/linked-list-in-binary-tree/description

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

//Try to do in optimal method
//Try to use KMP Algo
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;


        return findPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
        // return findPath(global_head, root.left) || findPath(global_head, root.right);

    }


    boolean findPath(ListNode head, TreeNode root){
        if(head == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(head.val == root.val){
            return findPath(head.next, root.left) || findPath(head.next, root.right);
        }

        return false;
    }
}
