//Leetcode URl - https://leetcode.com/problems/rotting-oranges/description/

class Solution {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        //will there be only one rotten orange or multiple?
        //Yes more than one rotting orange is allowed
        //and it can still be solved with a single BFS run just by inserting all the rotten oranges in the queue at the beginning, 
        //also called as multi source BFS.

        Queue<int[]> q = new LinkedList<>();
        int fresh_oranges = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh_oranges++;
                }
            }
        }

        //now do bfs with all in queue
        //so time is calculated when the bfs queue gets empty!!
        res = BFS(q, grid, fresh_oranges);

        return res;
    }


    int BFS(Queue<int[]> q, int[][] grid, int fresh_oranges){
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int time = 0;

        while(!q.isEmpty() && fresh_oranges > 0){
            int size = q.size();
            while(size > 0){    //to make sure its on same sec/level like in level order traversal of tree.
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] d : directions){
                    int x = i + d[0];
                    int y = j + d[1];

                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1){   //if its not fresh return.
                        continue;
                    }

                    grid[x][y] = 2;
                    fresh_oranges -= 1; //keep track of fresh oranges. we'll know when to stop.!!
                    q.add(new int[]{x,y});
                }

                size--;
            }
            time++;
        }

        return  fresh_oranges == 0 ? time : -1;
    }
}
