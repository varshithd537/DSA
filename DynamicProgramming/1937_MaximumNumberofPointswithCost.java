//LeetCode URL - https://leetcode.com/problems/maximum-number-of-points-with-cost/

class Solution {
    public long maxPoints(int[][] points) {
        //referred from this solution - https://leetcode.com/problems/maximum-number-of-points-with-cost/solutions/1344908/c-java-python-3-dp-explanation-with-pictures-o-mn-time-o-n-space

        //idea is to use previous result row at each index - and trying to find max after getting to last row
        //for every index, can find left max, right max - using dp technique optimally - of using previous index results
        //---refer the soln for good visual explanation
        //and current row results become previous row for next row
        
        int m = points.length;
        int n = points[0].length;

        long[] prev = new long[n];
        for(int i = 0; i < n; i++){
            prev[i] = points[0][i];
        }

        for(int i = 1; i < m; i++){
            long[] left = new long[n];
            long[] right = new long[n];
            long[] curr = new long[n];

            left[0] = prev[0];
            right[n-1] = prev[n-1];
            
            for(int j = 1; j < n; j++){
                left[j] = Math.max(left[j - 1] - 1, prev[j]);
            }

            for(int j = n-2; j >= 0; j--){
                right[j] = Math.max(right[j + 1] - 1, prev[j]);
            }

            for(int j = 0; j < n; j++){
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            prev = curr; //----!!
        }

        long res = 0;

        for(int i  = 0; i < n; i++){
            res = Math.max(res, prev[i]);
        }

        return res;
    }
}
