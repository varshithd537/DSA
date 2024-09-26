//Leetcode URL - https://leetcode.com/problems/set-matrix-zeroes/description/


//My idea is simple: store states of each row in the first of that row, and 
//store states of each column in the first of that column. Because the state of row0 and the state of column0 would occupy the same cell, 
//I let it be the state of row0, and use another variable col0 for column0. 
//In the first phase, use matrix elements to set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.

class Solution {
    public void setZeroes(int[][] matrix) {
        // Set<Integer> row = new HashSet<>();
        // Set<Integer> col = new HashSet<>();
        //sets is a good idea....!

        //can use first elements of row and col ...to be a flag!
        boolean col_zero = false;
        boolean row_zero = false;

      
        for(int i = 0; i < matrix.length; i++){   //check the first column
            if(matrix[i][0] == 0){
                col_zero = true;
                break;
            }
        }

        for(int i = 0; i < matrix[0].length; i++){ //check the first row
            if(matrix[0][i] == 0){
                row_zero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++){  //check except the first row and column
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    // row.add(i);
                    // row.add(j);
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){  //process except the first row and column
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }


        if(row_zero){    //Now, Handle the first column
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

        if(col_zero){    //Now, Handle the first row
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
       
    }
}
