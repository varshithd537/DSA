//LeetCode URL - https://leetcode.com/problems/permutation-in-string/description/

//Optimal way of sliding window - know the length of the window - add from end, remove from start
int front = 0;
int back = s1.length();
while(back < s2.length()){
    arr2[s2.charAt(front) - 'a']--;
    arr2[s2.charAt(back) - 'a']++;
    
    if(Arrays.equals(arr1, arr2)) return true;
    front++;
    back++;
}
//--------------------------------------------------------------

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        boolean res = false;
        int[] arr = new int[26];

        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }

        //should the frequecies match....how would you tackle it?
        //sliding window - if its failed....how would you reset the freq arr?
        int j = 0;
        int i = 0;
        int[] des = new int[26];
        int count = 0;
        //sliding window        
        while(j < s2.length()){
            if(count == 0){
                des = new int[26];
            }
    
            char curr = s2.charAt(j);
            if(arr[curr - 'a'] > 0){
                j++;
                des[curr - 'a']++;
                count++;
            }
            else{
                j++;
                i = j;
                count = 0;
            }

            if(count == s1.length()){
                if(equal(des, arr)){
                    return true;
                    //s1 =  "adc" s2 = "dcda" - gets wrong in this case
                }
                else{
                    // System.out.println(i +" "+j);
                    des[s2.charAt(i) - 'a']--;
                    i++;
                    count = count - 1;
                }
            }
        }

        return res;     
    }

    boolean equal(int[] arr1, int[] arr2){
        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
