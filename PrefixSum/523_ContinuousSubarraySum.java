//Leetcode URL - https://leetcode.com/problems/continuous-subarray-sum/description/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //Trying do it with hashset and Visualize how this solution is working under the hood!!
        boolean res = false;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0 , -1);   //!!!!!!

        int psum = 0;
        int j = 0;
        while(j < nums.length){
            psum += nums[j];
            int rem = psum%k;
            if(hmap.containsKey(rem)){
                // ensures that the size of subarray is at least 2
                if (j - hmap.get(rem) > 1) {
                    return true;
                }
            }
            //just storing the first occurence of rem!
            else{
                // mark the value of prefixMod with the current index.
                // hmap.put(rem, hmap.getOrDefault(rem, 0) + 1); - no need of count here
                hmap.put(rem, j);
            }
            j++;
        }

        return res;
    }
}
