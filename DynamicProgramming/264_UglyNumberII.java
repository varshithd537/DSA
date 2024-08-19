//LeetCode URL - https://leetcode.com/problems/ugly-number-ii/description

//All Approaches!! - Heap(PriorityQueue) && Dynamic Programming!!!

class Solution {
    public int nthUglyNumber(int n) {
        //One approach is to check isUgly() for every number till desired - kinda not optimal/bruteforce

        //Heap - based Approach
        // HashSet<Long> set = new HashSet<>();

        // PriorityQueue<Long> pq = new PriorityQueue<>();
        // pq.add((long)1);
        
        // while(!pq.isEmpty()){
        //     long curr = pq.poll();
        //     if(--n == 0){
        //         return (int)curr;
        //     }

        //     long two = curr*2;
        //     long three = curr*3;
        //     long five = curr*5;

        //     if(set.add(two)){
        //         pq.add(two);
        //     }

        //     if(set.add(three)){
        //         pq.add(three);
        //     }


        //     if(set.add(five)){
        //         pq.add(five);
        //     }
        // }

        // return 1;
//-----------------------------------------
//DP is used here because we are breaking the problem into smaller subproblems (finding the next ugly number) 
//and using previously solved subproblems (the already generated ugly numbers) to solve the larger problem 
//(finding the nth ugly number). We are also using heap, or the concept of merging 3 sorted lists, 
//to pick the minimum out of the next incoming ugly numbers, ensuring no number is repeated.
        
        //DP Approach
        
        //get rid of corner cases
        if(n <= 0){
            return 0;
        }

        //base case
        if(n == 1){
            return 1;
        }

        //ugly = pow(2,x)*pow(3,y)*pow(5,z);
        //careful of cases such as 6 = 2*3
        int p2 = 0, p3 = 0, p5 = 0; //pointers for 2, 3, 5

        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3,dp[p5]*5));
            ///wahhhhhh.....craze idea
            if(dp[i] == dp[p2]*2){
                p2++;
            }
            if(dp[i] == dp[p3]*3){
                p3++;
            }
            if(dp[i] == dp[p5]*5){
                p5++;
            }
        }

        return dp[n-1];
    }
}
