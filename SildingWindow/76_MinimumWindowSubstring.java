//Leetcode URL - https://leetcode.com/problems/minimum-window-substring/description/

class Solution {
    public String minWindow(String s, String t) {
        int[] occ = new int[58];
        int min = Integer.MAX_VALUE;
 
        String res = "";
        int total = 0;

        for(int i = 0; i < t.length(); i++){
            occ[t.charAt(i) - 'A']++;
        }

        int start = 0,end = 0,k = 0;
        boolean first = false;

        while(end < s.length()){
            char curr = s.charAt(end);
            if(occ[curr - 'A'] > 0){
                // System.out.println(curr);
                total++;
            }
            occ[curr - 'A']--; // Damnnn!!!!

            while(total == t.length()){
                if(min > (end - start + 1)){
                    res = s.substring(start,end + 1);
                    min = end - start + 1;
                }

                occ[s.charAt(start) - 'A']++;    //Damnn....crazyy.crazyy!
                //Increase the start - which checks for substrings of length less than current result,
                //while also satisying HAVE and WANT conditions between the desired substring and curr substring.
                if(occ[s.charAt(start) - 'A'] > 0){   //Important logic
                    total--;
                }
                start++;
            }
            
            // System.out.println(start+" "+end+ " "+ total);
            end++;
        }
        return res;
    }
}
