//LeetCode URL - https://leetcode.com/problems/maximum-distance-in-arrays/

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int minSoFar = arrays.get(0).get(0);
        int maxSoFar = arrays.get(0).get(arrays.get(0).size() - 1);

        //Set minSoFar, maxSoFar to be first/last element of first array.
        //Starting with second array, determine the max diff between maxSoFar - firstElement, lastElement - minSoFar.
        //Adjust min SoFar, maxSoFar according to first/last element of current array.

        for(int i = 1; i < arrays.size(); i++){
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size() - 1);

            res = Math.max(res,Math.max(Math.abs(minSoFar - max), Math.abs(maxSoFar - min)));
            minSoFar = Math.min(minSoFar, min);
            maxSoFar = Math.max(maxSoFar, max);
        }
        return res;
    }
}
