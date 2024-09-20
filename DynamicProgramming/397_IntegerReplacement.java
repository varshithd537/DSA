//LeetCode URL - https://leetcode.com/problems/integer-replacement/description/

class Solution {
    public int integerReplacement(int n) {
        //First implement bruteforce/Recursion - relation, then try to optimize finding the DP Equation
        //Space and Runtime Optimisation!!!
        
        //Bottom - Up Approach - Dynamic Programming 
        //each index in dp array represents the minimum number of operations for that number to become 1
        //so, we need to find for n -> last index of the array

        //dp[i] = 

        if(n == 1){
            return 0;
        }

        if(n == 2){
            return 1;
        }
        //what if n -> Max value of an integer
        if(n == Integer.MAX_VALUE){
            return 32;
        }
        
        if(n % 2 == 0){
            return 1 + integerReplacement(n/2);
        }
        else{
            return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));   //Minimum of n-1/ n+1
        }

    }
}
