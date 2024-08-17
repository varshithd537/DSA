//LeetCode URL - https://leetcode.com/problems/best-sightseeing-pair/

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0;
        int maxValue = values[0] + 0;
        res = maxValue;
        
        //What if maxValue and values[i] are equal??
        //so, that's why we are using a max value that is independent of index
        //maxtillnow of value[i] + i;
        //Rearranged formula, (values[i] + i) + (values[j] - j) instead of values[i] + values[j] + i - j
        for(int i = 1; i < values.length; i++){
            res = Math.max(res, maxValue + values[i] - i);
            if(values[i] + i > maxValue){
                maxValue = values[i] + i;
            }
        }

        return res;
    }
}
