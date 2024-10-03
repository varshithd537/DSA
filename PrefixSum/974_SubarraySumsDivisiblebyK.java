//Leetcode URL - https://leetcode.com/problems/subarray-sums-divisible-by-k/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int psum = 0;
        hmap.put(0, 1);

        int j = 0;
        while(j < nums.length){
            psum += nums[j];
            //condition to satisy -> (psum - (+-x))%k = 0;
            //so need to find that's when added should be divisible by k
            //so we search for remainder.

            // Take modulo twice to avoid negative remainders.

            int rem = ((psum%k) + k)%k;
            if(hmap.containsKey(rem)){
                res += hmap.get(rem);
            }

            hmap.put(rem, hmap.getOrDefault(rem, 0) + 1);
            j++;
        }

        return res;
    }
}
