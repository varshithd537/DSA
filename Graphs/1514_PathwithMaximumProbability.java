//LeetCode URL - https://leetcode.com/problems/path-with-maximum-probability/description/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double res = 0.0;
        HashMap<Integer, List<double[]>> hmap = new HashMap<>();

        //Generate Graph!
        //storing nodes and their neigbours in hashmap - kinda like adjaceny matrix
        for(int i  = 0; i < edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];

            List<double[]> src_list = hmap.getOrDefault(src, new LinkedList<double[]>());
            src_list.add(new double[]{des, succProb[i]}); 
            hmap.put(src, src_list);

            List<double[]> des_list = hmap.getOrDefault(des, new LinkedList<double[]>());
            des_list.add(new double[]{src, succProb[i]});
            hmap.put(des, des_list);
        }

        if(!hmap.containsKey(start)){
            return res;
        }

        // System.out.println(hmap);

        //Using Dijkstra's Algo
        //whereAs, we look here for maximum probability, instead of min cost
        //one thing we can use here to advantage is 0 to 1 weights....example x, y -> x > x*y -> monontonic nature
        //always probability decreases as we go through any path

        //the summation of non-negative weights in the original dijikstra's is equivalent to a multiplication of probabilities in this question, 
        //because both operations maintain the monotonic nature of routes getting more expensive as we go
        int[] visited = new int[n];

        PriorityQueue<double[]> pq = new PriorityQueue<double[]>(
            new Comparator<double[]>() {                 //Comparator.comparingDouble(i -> ) - easy Java comparator
            @Override
            public int compare(double[] a, double[] b) {
                // Reverse the natural order (max heap)
                if(b[1] > a[1]){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });

        pq.offer(new double[]{start, 1d});

        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            double curr_prob = curr[1];

            visited[(int)curr[0]] = 1;
            if((int)curr[0] == end){
                return curr_prob;
            }

            List<double[]> curr_list = hmap.get((int)curr[0]);

            for(int i = 0; i < curr_list.size(); i++){
                double[] arr = curr_list.get(i);
                if(visited[(int)arr[0]] == 0){
                    // arr[1] = curr_prob*arr[1]; //this line overlaps the value and the univisted nodes values change based on other iterations
                    //instead, we can just create new array for same node, and push to pq
                    pq.offer(new double[]{arr[0],curr_prob*arr[1]});
                }
            }
        }

        return res;
    }
}
