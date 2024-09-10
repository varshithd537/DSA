//Leetcode URL - https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    //Morris Traversal!!!!!!!
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new LinkedList<Integer>();
        TreeNode curr = root;

        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.val);
                curr = curr.right;
            }
            else{
                //Last Node(most right node) of left subtree -> root/current
                //first make it connected
                //after traversing remove it

                //second check is if it is already connected and visited

                //this iterates twice if you observe for every left subtree!
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{ //it means -> prev.right = curr - so make it null
                    prev.right = null;
                    inorder.add(curr.val);  //--current element, means all the left subtree is done
                    //check at elemental level...do not confuse!// do it on paper
                    curr = curr.right; //moving onto right!
                }
            }
        }
        return inorder;
    }
}
