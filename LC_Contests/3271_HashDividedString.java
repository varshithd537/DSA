//Contest - BiWeekly Contest 138
//Leetcode URL - https://leetcode.com/problems/hash-divided-string/description/

class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; ){
            String sub = s.substring(i, i + k);
            // System.out.println(sub);
            int sum = 0;
            for(int j = 0; j < k; j++){
                sum += (int)(sub.charAt(j) -'a');
            }
            // System.out.println(sum%26 + 61);
            sb.append((char)(sum%26 + 97));
            i = i + k;
        }

        return sb.toString();
    }
}
