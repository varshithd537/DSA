//Leetcode URL - https://leetcode.com/problems/count-the-number-of-complete-components/

//Build the Graph
public class Graph{
    HashMap<Integer, List<Integer>> adjList;
    public Graph(){
        adjList = new HashMap<>();
    }
                       
    public void addNode(int node){
        adjList.put(node, new ArrayList<Integer>());
    }

    public void addEdges(int u, int v){
        if(!adjList.containsKey(u)){
            addNode(u);
        }
        
        if(!adjList.containsKey(v)){
            addNode(v);
        }

        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public List<Integer> getNeighbours(int node){
        return adjList.get(node);
    }

}

class UnionFind{
    int[] id;
    int[] sz;
    int numComponents;
    int size;
    UnionFind(int size){
        this.size = size;
        numComponents = size;
        id = new int[size];
        sz = new int[size];
        for(int i = 0; i < size; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    int find(int node){
        int root = node;
        while(root != id[root]){
            root = id[root];
        }

        //Path Compression
        while(node != root){
            int next = id[node];
            id[node] = root;
            node = next;
        }

        return root;
    }

    boolean connected(int p, int q){
        return find(p) == find(q);
    }

    void unify(int p, int q){
        if (connected(p, q)) return;//!!!!!

        int root1 = find(p);
        int root2 = find(q);

        if(sz[root1] < sz[root2]){
            id[root1] = root2;
            sz[root2] += sz[root1];
            sz[root1] = 0;
        }
        else{
            id[root2] = root1;
            sz[root1] += sz[root2];
            sz[root2] = 0;
        }

        --numComponents;
    }

    int componentSize(int node){
        return sz[find(node)];
    }

}


class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        //Original intuition is iterate through the components
        //and Check the number of edgesd for each connnected nodes.
        //m - size of component and m(m-1)/2 be edges...then its completeconnected
        int res = 0;

        //Using UnionFind;
        Set<Integer> groups = new HashSet<>();
        int[] counter = new int[n]; //counting edges!
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++){
            uf.unify(edges[i][0], edges[i][1]);
            counter[edges[i][0]]++;
            counter[edges[i][1]]++;
        }

        for(int i = 0; i < n; i++){
            //we find parents of each component
            groups.add(uf.find(i));
        }

        for(int i = 0; i < n; i++){
            if(uf.componentSize(i) != counter[i] + 1){  //counter is degree -- {degree + 1 == no of nodes}.
                groups.remove(uf.find(i));
            }
        }

        return groups.size();
    }



//-----------------------------------------
        //Using DFS and Graphs!!!
        // int[] visited = new int[n];
        // Graph graph = new Graph();
        // for(int i = 0; i < n; i++){
        //     graph.addNode(i);
        // }

        // for(int i = 0; i < edges.length; i++){
        //     graph.addEdges(edges[i][0],edges[i][1]);
        // }

        // //DFS
        // for(int i = 0; i < n; i++){
        //     if(visited[i] == 0){
        //         if(connectedComponent(graph, i, visited)){
        //             res++;
        //         }
        //     }
        // }

        // return res;
    // }


    public boolean connectedComponent(Graph graph, int node, int[] visited){
        if(visited[node] == 1){
            return false;
        }

        int nodes = 0;
        int edges = 0;

        Stack<Integer> st = new Stack<Integer>();
        st.push(node);
        while(!st.isEmpty()){
            int curr = st.pop();
            if(visited[curr] == 0){
                nodes++;
            }

            visited[curr] = 1;
            List<Integer> list = graph.getNeighbours(curr);
            for(int i = 0; i < list.size(); i++){
                if(visited[list.get(i)] == 0){
                    edges++;
                    st.push(list.get(i));
                }
            }
        }

        return edges == (nodes*(nodes - 1))/2;
    }
}
