//LeetCode URL - https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //Binary Search
        //Identify the boundaries - least and highest - include all possibilities
        //have to find minimal k satisfying condition
        int total = 0;
        int max = -1;
        for(int w : weights){
            max = Math.max(max, w);
            total += w;
        }

        int left = max;
        int right = total;

        while(left < right){
            int mid = left + (right - left)/2;

            //check it it feasible
            if(isFeasible(weights, mid, days)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }

        return left;

    }

    public boolean isFeasible(int[] w, int capacity, int D){
        int total = 0;
        int days = 1;
        for(int i = 0; i < w.length; i++){
            total += w[i];
            if(total > capacity){   // too weight; so need to send it in next shipment
                total = w[i];
                days++;
                if(days > D){
                    return false;
                }
            }
        }

        return true;
    }
}
