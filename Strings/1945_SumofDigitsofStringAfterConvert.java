//Leetcode URL - https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/

class Solution {
    public int getLucky(String s, int k) {
        //Characters that map to more than one digit (e.g. 17, 24) can be converted to one during the first operation (e.g. 24 -> 6).
        //After that, we can just do the digital sum till k transforms.
        int sum = 0;
        int temp = 0;
        for(int i = 0; i < s.length(); i++){
            int digit = (int)s.charAt(i) - 96;
            sum += digit%10 + digit/10;
        }

        while(--k > 0 && sum > 9){
            temp = 0;
            while(sum > 0){
                temp += sum%10;
                sum = sum/10;
            }
            sum = temp;
        }

        return sum;
    }
}
