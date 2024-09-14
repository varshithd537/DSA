//LeetCode URL - https://leetcode.com/problems/k-items-with-the-maximum-sum/description/

class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        //OneLiner!!!!!
        return Math.min(k, numOnes) - Math.max(0, k - numOnes - numZeros);

        // while(k > 0){
        //     if(numOnes > 0){
        //         numOnes--;
        //         res++;
        //         k--;
        //     }
        //     else if(numZeros > 0){
        //         numZeros--;
        //         k--;
        //     }
        //     else{
        //         numNegOnes--;
        //         res--;
        //         k--;
        //     }
        // }
        // return res;
    }
}
