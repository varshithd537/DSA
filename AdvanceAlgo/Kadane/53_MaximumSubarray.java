//Leetcode URL - https://leetcode.com/problems/maximum-subarray/description/

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];

        // int currentSum = 0;
        // //Kadane's Algorithm!!
        // for(int i = 0; i < nums.length; i++){
        //     if(currentSum < 0){
        //         currentSum = 0;
        //     }

        //     currentSum += nums[i];
        //     res = Math.max(res, currentSum);
        // }
        // return res;

        //Kinda KADANE's with Sliding Window!!
        int left = 0;
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(currentSum < 0){
                left = i;
                currentSum = 0;
            }

            currentSum += nums[i];
            res = Math.max(res, currentSum);
            // if (curSum > maxSum) {
            //     maxSum = curSum;
            //     maxL = L; 
            //     maxR = R;     
            // } 
        }

        return res;
    }
}
