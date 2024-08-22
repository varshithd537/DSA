//LeetCode URL - https://leetcode.com/problems/number-complement/
//This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

//Try to do it in one-liner solution

class Solution {
    public int findComplement(int num) {

        //Using XOR functionality, you can use it to flip the bits
        //find the mask - which would be all 1's for as number of bits
        //find the bit count using bit manipulation shifts
        int count = 0;
        int res = num;
        while(num != 0){
            num = num >>> 1;
            count++;
        }

        //why these two lines produce different results when count is 31??
        // int mask = (int)Math.pow(2, count) - 1;
        int mask = (1 << count) - 1;

        return res ^ mask;
    }
}
