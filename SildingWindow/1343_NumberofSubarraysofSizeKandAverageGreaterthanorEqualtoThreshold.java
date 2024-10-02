//Leetcode URL - https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;

        int i = 0;
        int j = 0;
        double avg = 0.0;
        int sum = 0;

        while(j < arr.length){
            sum += arr[j];
            if(j - i + 1 >= k){
                avg = sum/k;
                if(avg >= threshold){
                    res++;
                }
                sum -= arr[i];
                i++;
            }

            j++;
        }

        return res;
    }
}

