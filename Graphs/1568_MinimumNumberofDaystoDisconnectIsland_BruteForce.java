//LeetCode Url - https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/

class Solution {
    public int minDays(int[][] grid) {
        int res = 0;

        int islandCount = 0;
        islandCount = countIslands(grid);

        if(islandCount != 1){   //Already disconnected - Case A
            return 0;   
        }

        //Case B - disconnecting 1 is enough
        //Trying bruteforce!!
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //only try to disconnect when the grid is land(1)
                if(grid[i][j] == 1){
                    //change land to water
                    //and check if the number of islands increased.
                    //do this by unmarking every land
                    grid[i][j] = 0;

                    if(countIslands(grid) != 1){
                        return 1;
                    }

                    //it didn't work out, revert back to land
                    grid[i][j] = 1;
                }
            }
        }

        //Case C - Enough Max value of 2 makes the grid disconnected.
        //No usecase takes more than 2. Check discussion!
        return 2;
    }


    int countIslands(int[][] grid){
        int res = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        //Mark all the visited nodes. and so once every 1 is visited the surrounding 1s will be visited. 
        //the more times it enters the dfs loop. the more islands are present.
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){  //if its 1 and not visited
                    searchDFS(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }


    void searchDFS(int[][] grid, int[][] visited, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return;
        }

        if(visited[i][j] == 1 || grid[i][j] == 0){
            return;
        }

        visited[i][j] = 1;
        searchDFS(grid, visited, i + 1, j);
        searchDFS(grid, visited, i, j + 1);
        searchDFS(grid, visited, i - 1, j);
        searchDFS(grid, visited, i, j - 1);
    }
}
