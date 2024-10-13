//Leetcode URl - https://leetcode.com/problems/pacific-atlantic-water-flow/description/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        int[][] flow = new int[m][n];
        //Can use 2 sets instead of this!!! and find common elements!!

        BFS(heights, 1, flow);
        BFS(heights, 2, flow);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(flow[i][j] == 2){
                    res.add(Arrays.asList(new Integer[]{i,j}));
                }
                // System.out.print(flow[i][j] + " ");
            }
            // System.out.println(" ");
        }

        return res;
    }


    void BFS(int[][] heights, int ocean, int[][] flow){
        int m = heights.length;
        int n = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        if(ocean == 1){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0 || j == 0){
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }
        else{
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == m - 1 || j == n - 1){
                        queue.add(new int[]{i, j});
                    }
                }
            }

        }

        int[][] visited = new int[m][n];
        int[][] directions = {{0,1} , {1, 0}, {0, -1} , {-1, 0}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(visited[curr[0]][curr[1]] == 0){
                flow[curr[0]][curr[1]] += 1;
                visited[curr[0]][curr[1]] = 1;
            }else{
                continue;
            }

            for(int[] d : directions){
                int p = curr[0] + d[0];
                int q = curr[1] + d[1];
                if(p >= m || q >= n || p < 0 || q < 0 || visited[p][q] == 1){
                    continue;
                }
                if(heights[curr[0]][curr[1]] <= heights[p][q]){
                    queue.add(new int[]{p, q});
                }
            }
        }
    }
}
