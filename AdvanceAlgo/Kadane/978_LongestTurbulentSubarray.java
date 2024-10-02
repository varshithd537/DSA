//LeetCode URL - https://leetcode.com/problems/longest-turbulent-subarray/description/

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;

        int left = 0;
        int right = 1;
        int prev = 0;   // 0 for = or nothing / 1 for > / 2 for < 

        //Kadane's !! Sliding Window !!

        while(right < arr.length){
            if(arr[right - 1] < arr[right] && prev != 2){
                res = Math.max(res, right - left + 1);
                right += 1;
                prev = 2;
            }
            else if(arr[right - 1] > arr[right] && prev != 1){
                res = Math.max(res, right - left + 1);
                right += 1;
                prev = 1;
            }
            else{
                prev = 0;
                if(arr[right - 1] == arr[right]){
                    right += 1;
                }
                left = right - 1;
            }
        }

        return res;
    }
}
