//LeetCode URL - https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description

class Solution {
    //a very good question on xor and prefix technique
    //Try to do it in One-pass or O(N)
    public int countTriplets(int[] arr) {
        int res = 0;
        int n = arr.length + 1;
        int[] prefix = new int[n];
        // prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
        }

        for (int i = 0; i < n; ++i){
            // System.out.println(prefix[i]);
            for (int j = i + 1; j < n; ++j){
                if (prefix[i] == prefix[j]){
                    res += j - i - 1;
                }
            }
        }

        return res;
    }
}
