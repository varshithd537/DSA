//LeetCode URL - https://leetcode.com/problems/longest-repeating-character-replacement/description/

class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxfreq = 0;

        int[] occ = new int[26];
        char[] arr = s.toCharArray();

        int start = 0;
        int end = 0;

        while(end < arr.length){
            occ[arr[end] - 'A']++;
            maxfreq = Math.max(maxfreq, occ[arr[end] - 'A']);

            //How do you find the most frequent element in the window without checking the occurences of everything again?
            //The result changes only when the maxfreq is going to change!!!!
            //so, even if you approximate the valid window we are not going to add it to the result until it increases;
            // and it increases when the window size increases along with the maxfreq
            while(end - start + 1 - maxfreq > k){
                occ[arr[start] - 'A']--;
                start++;
            }

            res = Math.max(res, end - start + 1);
            end++;
        }

        return res; 
    }
}


// ************!!!
// for(int i = 0; i < 26; i++){
//     if(maxCharCount < counts[i]){
//         maxCharCount = counts[i];
//     }
// }

// - Generic Solution

// for(end = 0; end < n; end++){
//     int endIdx = s.charAt(end) - 'A';
//     count[endIdx]++;
//     if(maxCharCount < count[endIdx]){
//         maxCharCount = count[endIdx];
//     }
//     while(end - start + 1 - maxCharCount > k){
//         count[s.charAt(start) - 'A']--;
//         start++;
//         for(int i = 0; i < 26; i++){
//             if(maxCharCount < count[i]){
//                 maxCharCount = count[i];
//             }
//         }
//     }
//     result = Math.max(result, end - start + 1);
