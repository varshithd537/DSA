//Leetcode URL - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

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
    public void flatten(TreeNode root) {
        //Morris Traversal

        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    // prev.right = null;
                    // curr = curr.right;
                    //!!!!!!!!----Original inOrder Morris Traversal

                    prev.right = curr.right;
                    // curr.right = prev; //----why not???? - missing few elems? 
                    //---- the elements between curr element and prev gets missing if you just point it directly to prev;
                    curr.right = curr.left;
                    curr.left = null;

                    curr = curr.right;
                }
            }
        }
    }
}

