//Contest - Weekly Contest 413
//Leetcode URL - https://leetcode.com/problems/k-th-nearest-obstacle-queries/description/

class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int dist = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);

            pq.offer(dist);
            if(pq.size() < k){
                res[i] = -1;
            }
            else if(pq.size() > k){
                pq.poll();
                res[i] = pq.peek();
            }
            else{
                res[i] = pq.peek();
            }      
        }
        return res;
    }
}
