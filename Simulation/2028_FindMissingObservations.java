//LeetCode Url - https://leetcode.com/problems/find-missing-observations/description

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] res = new int[n];
        int m = rolls.length;

        int x = 0;
        for(int i = 0; i < m; i++){
            x += rolls[i];
        }

        int desired_sum = mean*(m +n) - x;
        int default_val = desired_sum/n;
        int carry = desired_sum % n;

        if(desired_sum > n*6 || desired_sum < n*1){
            return new int[0];
        }

        int i = 0;
        while(carry > 0){
            res[i] = default_val;
            int diff = 6 - res[i];
            if(diff >= carry){
                res[i] += carry;
                carry = 0;
            }
            else{
                res[i] += diff;
                carry -= diff;
            }
            i++;
        }

        for( ; i < n ; i++){
            res[i] = default_val;
        }

        return res; 
    }
}
