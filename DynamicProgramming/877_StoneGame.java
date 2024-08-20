//LeetCode URL - https://leetcode.com/problems/stone-game/description/

// Try doing the SpaceOptimised Soln!!

class Solution {
    public boolean stoneGame(int[] piles) {

        //so the logic arrives when both ends are of same value, but which pile to pick?
        //the player would want to pick a pile that leads to a smallest possible pile to pick for opponent
        //ex : 5, 3, 6, 5 => 3, 6, 5 / 5, 3, 6

        //SO, have to the future optimal path before selecting which one to take - SubProblems of deciding at each state - 
        //one might propose to make a greedy choice that maximizes points in the next 2 steps. 
        //However, it leads to the same problem because we are still looking just 2 steps ahead instead of n steps.

//-----------------------------------------------------------------------
        //optimization problem - Dynamic Programming!!
        //Why not greey?, but DP??!!!
        //Nice Article - https://medium.com/algorithms-digest/predict-the-winner-16668e9c1cb8
        //Refer - https://leetcode.com/problems/predict-the-winner/
//-----------------------------------------------------------------------

        //Just return TRUE!!
        //In the description, we know that sum(piles) is odd and even number of piles of stones.
        //If sum(piles[even]) > sum(piles[odd]), Alex just picks all evens and wins.
        //If sum(piles[even]) < sum(piles[odd]), Alex just picks all odds and wins.

        //DP soln
        int n = piles.length;

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
                    dp[j][j + len] = piles[j];
                }
                // else if(start + 1 == end){
                //     dp[j][j + len] = Math.max(piles[start], piles[end]); //nums(j), nums(j + len)
                // }
                else{
                    int choice_1 = piles[start] - dp[start + 1][end]; 
                    int choice_2 = piles[end]  - dp[start][end - 1];

                    dp[j][j + len] = Math.max(choice_1, choice_2);
                }
            }
        }
        return dp[0][n -1] > 0; 
        //dp[0][n -1] >= cum[n-1] - dp[0][n-1]; -- not using cummmulative sum here, contrasting to the predict-the-winner problem
    }
}
