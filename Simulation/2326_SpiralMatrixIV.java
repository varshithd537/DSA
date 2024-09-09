//Leetcode Url - https://leetcode.com/problems/spiral-matrix-iv/description/

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
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = -1;
            }
        }

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int row = 0;
        int col = 0;
        int curr_dir = 0;

        while(head != null){
            res[row][col] = head.val;
            head = head.next;

            //adding length - (to avoid negative index) and doing mod with it, so if it doesn't go out of bounds
            int nextRow = (row + dir[curr_dir][0] + m) % m;
            int nextCol = (col + dir[curr_dir][1] + n) % n;

            if(res[nextRow][nextCol] != -1){
                curr_dir = (curr_dir + 1) % 4;
            }

            row += dir[curr_dir][0];
            col += dir[curr_dir][1];
        }

        return res;
    }
}
