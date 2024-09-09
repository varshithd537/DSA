//LeetCode URL - https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int num = 1;
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int row = 0;
        int col = 0;
        int curr_dir = 0;
        while(num <= n*n){
            res[row][col] = num++;
            // num++;
            //change the direction if next cell is not zero or out of bounds; - beware of -ve indexes
            //so the addition of n and mod of n gives the next index if row and col are going to change in next iteration
            int nextRow = (row + dir[curr_dir][0] + n)%n;
            int nextCol = (col + dir[curr_dir][1] + n)%n;

            //---------int r = Math.floorMod(row + dir[d][0], n);
            //---------int c = Math.floorMod(col + dir[d][1], n);

            //we use floorMod in Java instead of modulo % to handle mod of negative numbers.
            //This is required because row and column values might go negative and using % won't give desired results in such cases.

            if(res[nextRow][nextCol] != 0){
                curr_dir = (curr_dir+1)%4; //----change to next direction!
            }

            //Moving to the next cell;
            row += dir[curr_dir][0];
            col += dir[curr_dir][1];
        }

        return res;
    }
}
