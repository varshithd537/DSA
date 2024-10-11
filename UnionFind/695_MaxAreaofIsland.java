//Leetcode URL - https://leetcode.com/problems/max-area-of-island/description/

class UnionFind{
    int[] id;
    int[] sz;
    int size;
    int numComponents; //here it is basically number of islands
    UnionFind(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        numComponents = 0;
        size = m*n;
        id = new int[size];
        sz = new int[size];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    numComponents++;
                    int currIndex = i*n + j;
                    id[currIndex] = currIndex;
                    sz[currIndex] = 1;
                }
            }
        }
    }

    int find(int p){
        int root = p;
        while(root != id[root]){
            root = id[root];
        }

        while(p != root){
            int temp = id[p];
            id[p] = root;
            p = temp;
        }

        return root;
    }

    boolean connected(int p, int q){
        return find(p) == find(q);
    }

    void union(int p, int q){
        int root1 = find(p);
        int root2 = find(q);

        if(connected(root1, root2)){
            return;
        }

        if(sz[root1] > sz[root2]){
            id[root2] = root1;
            sz[root1] += sz[root2];
            sz[root2] = 0;
        }
        else{
            id[root1] = root2;
            sz[root2] += sz[root1];
            sz[root1] = 0;
        }

        --numComponents;
    }

    int components(){
        return numComponents;
    }

    int componentSize(int p){
        return sz[find(p)];
    }
}

// TC : O(rows*cols*alpha) , alpha being constant can be ignored
// SC : O(rows*cols)


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        //Try to do using UnionFind
        UnionFind uf = new UnionFind(grid);
        
        //Now unify based on the islands
        int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }

                int currIndex = i*n + j;
                //find neighbours which are equal to 1
                //Can decrease some redundant calls here
                for(int[] d : distance){
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) { 
                        int neighbourIndex = x*n + y;
                        uf.union(currIndex, neighbourIndex);  
                    }
                }
            }
        }

        // System.out.println(uf.components());

        //check for components size;
        for(int i = 0; i < uf.size; i++){
            res = Math.max(res, uf.sz[i]);
        }

        return res;
    }
}
