//https://leetcode.com/problems/maximum-sum-circular-subarray/description/


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int maxSum = nums[0];   //!!!! Edge case - if we use 0, what if every value is negative?, So, keep it as any element.
        int currentMaxSum = 0;
        int minSum = 0;
        int currentMinSum = 0;
        int total = 0;

        for(int i = 0; i < n; i++){
        // Trying to find MinSubArray for case 2 -  Situations!!
        //Case 1 - its just normal maxSubArray 
        //Case 2 - maxSubArray is divided as head and tail with - middle being a minimum possible subArray

        //so to find minSubArray, just do the same kadane's Algo as maxSubArray, but to get minimum.
            if(currentMaxSum < 0){
                currentMaxSum = 0;
            }

            //CurrentMaxSum = Math.max(currentMaxSum, currentMaxSum + nums[i]);

            if(currentMinSum > 0){
                currentMinSum = 0;
            }
            currentMaxSum += nums[i];
            maxSum = Math.max(maxSum, currentMaxSum);

            currentMinSum += nums[i];
            minSum = Math.min(minSum, currentMinSum);

            total += nums[i];
        }

        //to handle when maxSum cases are less than 0
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
        // return Math.max(maxSum, total - minSum);
        
        // for(int i = 0; i < 2*n - 1 && i - left <= n; i++){
        //     // System.out.println(res + " " +nums[i%n]);
        //     if(currentSum < 0){
        //         currentSum = 0;
        //         left = i;
        //     }

        //     currentSum += nums[i % n];
        //     res = Math.max(res, currentSum);
        // }

        // return res;
    }
}
