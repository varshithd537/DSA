// Leetcode URl - https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/

class Solution {
    public int minBitFlips(int start, int goal) {
        int res = 0;
        
        //Find the XOR and the bits that are ones, are the flipped bits
        int temp = start^goal;

        //Count the bits(1s) - Brian Kerninghan's Algorithm
        while(temp > 0){
            temp = temp & (temp - 1);
            res++;
        }
        return res;
    }
}
