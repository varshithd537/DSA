//Leetcode URL - https://leetcode.com/problems/clone-graph/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> hmap;
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        //every node should have all of its edges as original, given undirecred graph (bidrectional edges).
        //create a hashmap with old nodes and pointing to the newly created nodes.
        //recursive solution.

        hmap = new HashMap<>();
        return createClone(node);
    }


    public Node createClone(Node old){
        if(hmap.containsKey(old)){
            return hmap.get(old);
        }

        Node clone = new Node(old.val);
        hmap.put(old, clone);

        for(Node neighbor : old.neighbors){
            // clone.neighbors.append(new Node(neighbor.val));
            //should write a recursive step here, as we need to duplicate the neighbors as well
            //and track them using hashmap
            clone.neighbors.add(createClone(neighbor));
        }

        return clone;
    }
}
