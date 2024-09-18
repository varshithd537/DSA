//LeetCode URL - https://leetcode.com/problems/add-binary/description/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(j >= 0){
                //- '0' part converts the character to its integer value
                sum += b.charAt(j--) - '0';
            }

            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum%2);
            //gives us the correct bit for the current position (0 if sum is 0 or 2, 1 if sum is 1 or 3).
            carry = sum/2;
            //sum / 2 gives us the correct carry (0 if sum is 0 or 1, 1 if sum is 2 or 3).
        }

        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
