//LeetCode URL - https://leetcode.com/problems/predict-the-winner/

class Solution {
    public boolean predictTheWinner(int[] nums) {
        //Refer to this article - https://medium.com/algorithms-digest/predict-the-winner-16668e9c1cb8
        //Very Good Explanation

        if(nums == null){ return true; }

        int n = nums.length;
        int[] cum = new int[n];

        cum[0] = nums[0];
        for(int i = 1; i < n; i++){
            cum[i] = nums[i] + cum[i - 1];
        }

        int[][] dp = new int[n][n];

        for(int len = 0; len < n; len++){ // - len acts as a step or length from diagnol

            //just the upper diagnol side of the table 
            //table need to be filled in order the length from diagnol
            //!!!!!very important on how you traverse

            // j, j + len from diagnol
            //to avoid out of bounds -> j < n - len
            for(int j = 0; j < n - len ; j++){
                //start and end of subarrays - subproblems
                int start = j;
                int end = j + len;

                //Base Case - diagnol elements 
                if(start == end){
                    dp[j][j + len] = nums[j];
                }
                else if(start + 1 == end){
                    dp[j][j + len] = Math.max(nums[start], nums[end]); //nums(j), nums(j + len)
                }
                else{

                    //choice 1 - pick start element 
                    //then other player picks from nums[start + 1]......nums[end] - optimally so
                    //nums[start] + cum[end] - cum[start] - dp[start + 1][end]

                    int choice_1 = nums[start] + (cum[end] - cum[start] - dp[start + 1][end]); //-cumSum[start+1]+nums[start+1]

                    //choice 2 - pick end element
                    int choice_2 = nums[end] + (cum[end - 1] - cum[start] + nums[start] - dp[start][end - 1]);

                    dp[j][j + len] = Math.max(choice_1, choice_2);
                }
            }
        }
        return dp[0][n -1] >= cum[n-1] - dp[0][n-1];
    }
}
