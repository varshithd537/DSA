//LeetCode URL - https://leetcode.com/problems/word-pattern/description/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        //Check all submiited solutions once and learn why it is happening!!
        HashMap hmap = new HashMap<>(); //Why is it turns out wrong if hashmap datatypes are defined to <String, Integer>...?

        int len = pattern.length();
        String[] arr = s.split(" ");
        int n = arr.length;
        if(len != n){
            return false;
        }

        for(Integer i = 0; i < n; i++){     //why it turns out wrong when using int instead of Integer.??
            //HashMap.put() returns....!! :OOO
            //The previous value: associated with the specified key, or
            //null: if there was no mapping for the key.
            if(hmap.put(pattern.charAt(i), i) != hmap.put(arr[i], i)){  
                return false;
            }
        }
        return true;
    }
}
