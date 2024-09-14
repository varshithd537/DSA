//Leetcode URL - https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description

class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int count = 0;

        //The Bitwise AND of two different numbers will always be strictly less than the maximum of those two numbers
        //so the longest subarray with max bitwise AND would be the subarray containing only the max numbers
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                count++;
                res = Math.max(res, count);
            }
            else{
                count = 0;
            }
        }

        return res;   
    }
}
