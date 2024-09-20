//Leetcode URL - https://leetcode.com/problems/shortest-palindrome/

class Solution {
    public String shortestPalindrome(String s) {
        //KMP algorithm----!!! Very Optimal and Complicated!!
        //Create the LPS(Longest_Prefix_Suffix) Table!!!! - Do follow Neetcode code

        //So to use the KMP technique in this question,
        //as we need the string to be palindromic,
        //we need the longest-prefix-suffix possible when the string and its reverse are combined
        //And the remaining length of characters is what we add infront the string to make it PALINDROME!!!

        int[] LPS = getLPS(s);

        return new StringBuilder(s.substring(LPS[LPS.length - 1], s.length())).reverse().toString() + s;
    }

    int[] getLPS(String s){
        //Adding an extra character in middle - for the edge cases!!
        String temp = s+"#"+new StringBuilder(s).reverse().toString();
        int len = temp.length();
        int[] LPS = new int[len];

        char[] st = temp.toCharArray();
        int prevLPS = 0;
        int i = 1;

        while(i < len){
            if(st[i] == st[prevLPS]){
                LPS[i] = prevLPS + 1;
                prevLPS += 1;
                i += 1;
            }
            else{
                if(prevLPS == 0){
                    LPS[i] = 0;
                    i += 1;
                }
                else{
                    prevLPS  = LPS[prevLPS - 1];
                }
            }
        }

        return LPS;
    }
}
