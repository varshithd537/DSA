//LeetCode URL - https://leetcode.com/problems/make-sum-divisible-by-p/description

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int res = n;

        int rem = 0;
        for(int j = 0; j < n; j++){
            rem = (rem + nums[j]) % p;
        }

        //Find the shortest array with sum % p = rem.
        //We have done /974_SubarraySumsDivisiblebyK already : kinda similiar to that now
        //have to check for edge cases and while calculating minimum length

        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, -1);
        
        int psum = 0;
        for(int j = 0; j < n; j++){
            psum = (psum + nums[j]) % p;
            hmap.put(psum, j);

            //avoiding negative remainders
            int want = (psum - rem + p) % p;
            
            if(hmap.containsKey(want)){
                res = Math.min(res, j - hmap.get(want));
            }
            // else{
            //     res = Math.min(res, j + n);
            // }
            
        }

        return res == n ? -1 : res;
    }
}
