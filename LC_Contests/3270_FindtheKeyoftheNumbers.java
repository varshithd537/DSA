//Contest - BiWeekly Contest 138
//Leetcode URL - https://leetcode.com/problems/find-the-key-of-the-numbers/description/

class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int res = 0;
        
        int pow = 0;
        int count = 4;
        while(count > 0){
            int curr = 9;
            if(num1 > 0){
                curr = Math.min(curr,num1%10);
                num1 = num1/10;
            }
            else{
                curr = 0;
            }
            
            if(num2 > 0){
                curr = Math.min(curr,num2%10);
                num2 = num2/10;
            }
            else{
                curr = 0;
            }
            
            if(num3 > 0){
                curr = Math.min(curr,num3%10);
                num3 = num3/10;
            }
            else{
                curr = 0;
            }
            res += curr*Math.pow(10,pow);
            pow++;
            count--;
        }
    
        return res;
    }
}
