//Leetcode URL - https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class Graph{
    HashMap<Integer, List<Integer>> adjList;
    Graph(){
        adjList = new HashMap<>();
    }

    void addNode(Integer node){
        adjList.put(node, new ArrayList<Integer>());
    }

    void addEdges(int[] edge){
        if(!adjList.containsKey(edge[0])){
            addNode(edge[0]);
        }

        if(!adjList.containsKey(edge[1])){
            addNode(edge[1]);
        }

        //as given in the Q, bidirectional
        adjList.get(edge[0]).add(edge[1]);
        adjList.get(edge[1]).add(edge[0]);
    }

    List<Integer> getNeighbours(int node){
        return adjList.get(node);
    }
}

//-----------------------------------------------------------
//Try doing with UNION-FIND!!!!
//The Main logic would be finding if source and destination are in the same connected component.
public class UnionFind{
    // id[i] points to the parent of i, if id[i] = i then i is a root node
    int[] id;
    
    // Used to track the size of each of the component
    int[] sz;
    
    // The number of elements in this union find
    int size;
    int numComponents;

    public UnionFind(int size){
        this.size = size;
        id = new int[size];
        sz = new int[size];
        this.numComponents = size;

        for (int i = 0; i < size; i++) {
            id[i] = i; // Link to itself (self root)
            sz[i] = 1; // Each component is originally of size one
        }
    }

    //finds the parent of given element......finding its component/disjoint set
    public int find(int ele){
        int node = ele;
        //till its parent(of set/component), i:e found a self-loop.
        while(node != id[node]){
            node = id[node];
        }

        //node is now having the parent.
        //Now, lets do path compression for the same path we found till root;
        //make every element's parent as same as the parent of component.
        while(ele != node){
            int next = id[ele];
            id[ele] = node;
            ele = next;
        }

        return node;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    //Unify components containing p and q elements.
    public void unify(int p, int q){
        int root1 = find(p);
        int root2 = find(q);

        if(connected(p, q)){
            return;
        }

        //merging smaller components/set into larger one
        if(sz[root1] < sz[root2]){
            id[root1] = root2;
            sz[root2] += sz[root1];
            sz[root1] = 0;  //only roots have the size
        }
        else{
            id[root2] = root1;
            sz[root1] += sz[root2];
            sz[root2] = 0;
        }

        // Since the roots found are different we know that the
        // number of components/sets has decreased by one
        numComponents--;
    }

    // Return the size of the components/set 'p' belongs to
    public int componentSize(int p) {
        return sz[find(p)];
    }

    // Return the number of elements in this UnionFind/Disjoint set
    public int size() {
        return size;
    }

    // Returns the number of remaining components/sets
    public int components() {
        return numComponents;
    }
}



class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //UNION-FIND
        //Given the size n, form the components/sets based on that
        //and do union based the relations, which are edges in our case
        //and as given bi-drectional graph, we just need to find if source, destination belongs to same set/not;

        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < edges.length; i++){
            uf.unify(edges[i][0], edges[i][1]);
        }

        return uf.connected(source, destination);


//--------------------------------------------------------------------
        // Graph graph = new Graph();
        // for(int i = 0; i < edges.length; i++){
        //     graph.addEdges(edges[i]);
        // }

        //as graph may contain cycles, Should need to track the visited nodes.
        // int[] visited = new int[n];
        // return DFS(graph, visited, source, destination);

        //-----------------------------------------------------------------
        
        //Doing BFS using Queue: -- TLE
        // Queue<Integer> q = new LinkedList<>();
        // q.offer(source);
        // visited[source] = 1;

        // while(!q.isEmpty()){
        //     int curr = q.poll();
        //     if(curr == destination){
        //         return true;
        //     }

        //     visited[curr] = 1;

        //     List<Integer> list = graph.getNeighbours(curr);
        //     for(int i = 0; i < list.size(); i++){
        //         if(visited[list.get(i)] == 0){
        //             q.offer(list.get(i));
        //         }
        //     }
        // }

        //-----------------------------------------------------------------

        // //Doing DFS Iteratively using Stack; -- TLE
        // Stack<Integer> st = new Stack<Integer>();
        // st.push(source);
        // visited[source] = 1;

        // while(!st.isEmpty()){
        //     int curr = st.pop();
        //     if(curr == destination){
        //         return true;
        //     }
        //     visited[curr] = 1;

        //     List<Integer> list = graph.getNeighbours(curr);
        //     for(int i = 0; i < list.size(); i++){
        //         if(visited[list.get(i)] == 0){
        //             st.push(list.get(i));
        //         }
        //     }
        // }

        // return false;
    }


    public boolean DFS(Graph graph, int[] visited, int source, int destination){
        if(source == destination){
            return true; 
        }

        visited[source] = 1;
        List<Integer> list = graph.getNeighbours(source);
        for(int i = 0; i < list.size(); i++){
            int curr = list.get(i);
            if(visited[curr] == 0){
                //ONLY shoud return(true) when its found, so that next iteration takes place.
                if(DFS(graph, visited, curr, destination)){
                    return true;
                }
            }
        }
        return false;
    }
}
