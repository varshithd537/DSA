//LeetCode URL - https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();

        HashMap<Character, Integer> hmap = new HashMap<>();
        while(right < arr.length){
            if(hmap.containsKey(arr[right])){
                //if the element is already in the window - duplicate
                if(hmap.get(arr[right]) >= left){
                    left = hmap.get(arr[right]) + 1;
                }
            }
            hmap.put(arr[right], right);
            res = Math.max(res, right - left + 1);
            right += 1;
        }

        return res;
    }
}
