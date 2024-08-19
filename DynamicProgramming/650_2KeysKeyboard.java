//LeetCode URL - https://leetcode.com/problems/2-keys-keyboard/description/
//Solution URL posted by me - https://leetcode.com/problems/2-keys-keyboard/solutions/5658266/simple-math-explanation-with-easy-implementation-of-java-dp-solution

class Solution {
    public int minSteps(int n) {
        //following math pattern - it. can be observed that sub problems of the problem depends on factors of number
        //find the highest factor - you get the optimal soln 
        // you can know number = dp[highestfactor] + dp[smallestfactor]; other than 1 and itself!!!!!

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        if(n <= 1){
            return 0;
        }

        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            int factor = biggestFactor(i);
            if(factor == i){
                dp[i] = i;
            }
            dp[i] = dp[factor] + dp[i/factor];
        }

        return dp[n];
    }

    int biggestFactor(int num){
        if(num % 2 == 0){
            return num / 2;
        }

        int stop = (int)Math.sqrt(num);
        for(int i = 3; i <= stop; i += 2){  //because of prime squares
            if(num%i == 0){
                return num/i;
            }
        }

        return num;
    }
}
