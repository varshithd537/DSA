//Leetcode URL - https://leetcode.com/problems/subarray-sum-equals-k/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        //Solve it using prefix sum technique

        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int psum = 0;
        for(int i = 0; i < nums.length; i++){
            System.out.println(hmap);
            psum += nums[i];
            if(hmap.containsKey(psum - k)){
                res += hmap.get(psum - k);
                System.out.println(res);
            }

            hmap.put(psum, hmap.getOrDefault(psum, 0) + 1);
        }

        return res;
    }
}
