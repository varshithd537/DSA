//LeetCode URL - https://leetcode.com/problems/spiral-matrix/description/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        
        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int row = 0;
        int col = 0;
        int d = 0;
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m*n;

        while(count < total){
            res.add(matrix[row][col]);
            matrix[row][col] = -101;
            count++;

            int nextRow = (row + dir[d][0] + m) % m;
            int nextCol = (col + dir[d][1] + n) % n;

            if(matrix[nextRow][nextCol] == -101){
                d = (d + 1)%4;
            }

            row += dir[d][0];
            col += dir[d][1];
        }

        return res;
    }
}
