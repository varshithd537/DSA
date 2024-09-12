//LeetCode URL - https://leetcode.com/problems/count-the-number-of-consistent-strings

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        int[] occ = new int[26];
        for(int i = 0; i < allowed.length(); i++){
            occ[allowed.charAt(i) - 'a']++;
        }

        for(int i = 0; i < words.length; i++){
            String curr = words[i];
            boolean check = true;
            for(int j = 0; j < curr.length(); j++){
                if(occ[curr.charAt(j) - 'a'] <= 0){
                    check = false;
                    break;
                }
            }
            if(check){
                res++;
            }
        }

        return res;
    }
}
