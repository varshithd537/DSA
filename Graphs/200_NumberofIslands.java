//LeetCode URL - https://leetcode.com/problems/number-of-islands/description/

class Solution {

    public int numIslands(char[][] grid) {
        int res = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        //Try to do using UnionFind
        
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    search(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void search(char[][] grid, int[][] visited, int i, int j){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        
        if(visited[i][j] == 1 || grid[i][j] == '0' ){
            return;
        }

        visited[i][j] = 1;
        search(grid, visited, i + 1, j);
        search(grid, visited, i, j + 1);
        search(grid, visited, i - 1, j);
        search(grid, visited, i, j - 1);
    }
}

    
