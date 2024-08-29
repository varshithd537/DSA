//LeetCode URL - https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/

//Very good application of multiple key topics - Practice/Solve it again!

//Also refer to @lee215's solution!!!

class Solution {
    public int removeStones(int[][] stones) {
        //Find the number of "connected components - Graph" using DFS and 
        //then subtract the number of connected components from the length of the stones.
        int res = 0;
        int n = stones.length;
        
        //build the adjacency list for each stone
        List<Integer>[] adj_list = new LinkedList[n];
        for(int i = 0; i < n; i++){
            adj_list[i] = new LinkedList<>();
        }

        //generate the graph
        //compare each stone, if they are connectd
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    adj_list[i].add(j);
                    adj_list[j].add(i);
                }
            }
        }

        int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(adj_list, visited, i);
                res++;
            }
        }

        //find total of clusters(connected components)!!!
        //no. of stones - clusters
        return n - res;
    }

    void dfs(List<Integer>[] adj_list, int[] visited, int stone){
        visited[stone] = 1;

        for(int neighbour : adj_list[stone]){
            if(visited[neighbour] == 0){
                dfs(adj_list, visited, neighbour);
            }
        }
    }
}


//hard way //Using Union Find - create an edge between two coordinates if they share a common x or y coordinate. 
//Then, use union-find by size (not rank) and sum all the sizes. Return this sum.
//The reason we sum all the sizes is that if a coordinate shares a row or column, it is basically connected to the nodes. 
//To make a node independent, we need to remove every node that is connected to this node
