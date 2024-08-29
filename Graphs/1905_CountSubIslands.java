//LeetCode URL - https://leetcode.com/problems/count-sub-islands/description

class Solution {
    //Try to do using UNION-FIND!!!!
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;

        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1){
                    res += isSubIsland(grid1, grid2, i, j);
                }
            }
        }
        //another alternative is to first visit all the locations where there is water in grid1
        //and make it as water in grid2
        //and now just count the islands in grid2

        return res;
    }


    //return 0 if and only if we find it's not a sub island.
    //no need to extra array for visited - change the grid2 values
    int isSubIsland(int[][] map, int[][] grid, int i, int j){
        int res = 1;
        //if its out of border, just return 1 or true 
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0 ){
            return 1; // ??????
        }
        else{
            grid[i][j] = 0; //marking it as visited

            int left = isSubIsland(map, grid, i, j - 1);
            int right = isSubIsland(map, grid, i, j + 1);
            int top = isSubIsland(map, grid, i - 1, j);
            int bottom = isSubIsland(map, grid, i + 1, j);

            //tricky - if writing if conditions!!
            //The key difference between && and & operators 
            //&& supports short-circuit evaluations while & operator does not

            res &= left & right & top & bottom;
        }

        return res & map[i][j];
    }

    //Short-Circuit Evaluation!!
    //In this case, never write code like this:
    //result = isSubIsland(grid1, grid2, i, j -1) && isSubIsland(grid1, grid2, i, j +1) && isSubIsland(grid1, grid2, i-1, j ) && isSubIsland(grid1, grid2, i+1, j )
    //Becuase in this scenario, if the first two cases will be false, then the other two methods will not be executed, which will result in failure of test cases.
}
