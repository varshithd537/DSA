//Contest - Weekly Contest 413
//Leetcode URL - https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/

class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        boolean res = false;

        int color1 = (int)coordinate1.charAt(0) + (int)coordinate1.charAt(1);
        int color2 = (int)coordinate2.charAt(0) + (int)coordinate2.charAt(1);

        if(color1%2 == color2%2){
            return true;
        }
        return res;
    }
}
