//LeetCode URL - https://leetcode.com/problems/shifting-letters/description/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        char[] arr = s.toCharArray();
        for(int i = n - 1; i >=0; i--){
            if(i != n - 1){
                shifts[i] += shifts[i + 1];
            }
            if(shifts[i] >= 26){
                shifts[i] = shifts[i]%26;
            }
        }

        for(int i = 0; i < n; i++){
            int temp = (int)(arr[i] - 'a') + shifts[i];
            temp = temp%26 + 97;
            arr[i] = (char)(temp);
        }

        return String.valueOf(arr);  
    }
}
