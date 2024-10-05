//LeetCode URL - https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/


class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m * k){
            return -1;
        }

        int max = -1;
        for(int b : bloomDay){
            max = Math.max(max, b);
        }
        //Set the boundaries of possibilities!!
        //check the possibilities of days using modified Binary Search!

        int left = 1;
        int right = max;

        while(left < right){
            int mid = left + (right - left)/2;

            //check it it feasible
            if(isFeasible(bloomDay, mid, m, k)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return left;

    }

    public boolean isFeasible(int[] bloomDay, int mid, int m, int k){
        int flowers = 0;
        int bonquets = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] > mid){
                flowers = 0;    //means can't plant any flowers; // so series broken
            }
            else{
                bonquets += (flowers + 1)/k; //exisiting value of flowers + new addition one
                flowers = (flowers + 1)%k; //remaining flowers after using for creating bonquet
            }
        }

        return bonquets >= m;
    }
}
