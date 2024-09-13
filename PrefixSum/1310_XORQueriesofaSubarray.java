//Leetcode URL - https://leetcode.com/problems/xor-queries-of-a-subarray/description/

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int q_len = queries.length;
        int[] res = new int[q_len];
        int[] prefix = new int[n];

        //find the xor for first index till each index - just like how we calculate the prefix sum
        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = arr[i] ^ prefix[i - 1];
        }

        // the trick here is xor of same number nullify - 
        //so, while finding xor of ranges, use the prefix xor calculated to get desired value!
        for(int i = 0; i < q_len; i++){
            int a = queries[i][0];
            int b = queries[i][1];

            if(a - 1 < 0){
                res[i] = prefix[b];
            }
            else{
                res[i] = prefix[b]^prefix[a - 1];
            }
        }

        return res;
    }
}
