//LeetCode URL - https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);

        int i = 0;
        while(i < s.length() - 1){
            char curr = s.charAt(i);
            if(hmap.get(curr) < hmap.get(s.charAt(i+1))){
                res -= hmap.get(curr);
            }
            else{
                res += hmap.get(curr);
            }
            i++;
        }

        res += hmap.get(s.charAt(s.length() - 1));

        return res;
    }
}
