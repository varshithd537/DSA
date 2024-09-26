//Leetcode URL - https://leetcode.com/problems/different-ways-to-add-parentheses/description/

class Solution {
    
    public List<Integer> diffWaysToCompute(String expression) {
        //Every number is a leaf node, and the operations +,-,* are not. 
        //A preOrder/postOrder transversal for a airthmetic formula is equivalent to its corresponding inOrder transversal with parentheseses.
        //Hint: recursive formula for Catalan numbers.
        //Learn the above prospective solns and their concepts

        return backtrack(0, expression.length() - 1, expression);
    }

    public List<Integer> backtrack(int left, int right, String expression){
        List<Integer> res = new LinkedList<>();

        //Recursion with backtracking!!
        for(int i = left; i <= right; i++){
            char curr = expression.charAt(i);

            if(curr == '+' || curr == '-' || curr == '*'){
                List<Integer> nums1 = backtrack(left, i - 1, expression);
                List<Integer> nums2 = backtrack(i + 1, right, expression);

                for(int a = 0; a < nums1.size(); a++){
                    for(int b = 0; b < nums2.size(); b++){
                        int temp = 0;
                        switch(curr){
                            case '+':
                                temp = nums1.get(a) + nums2.get(b);
                                break;
                            case '-':
                                temp = nums1.get(a) - nums2.get(b);
                                break;
                            case '*':
                                temp = nums1.get(a) * nums2.get(b);
                                break;
                        }
                        res.add(temp);
                    }
                }

            }

        }

        //Base Case!!! - when the range of left and right doesn't have any operators - list is empty
        //so we know that's a number/operand! - append it to the list
        if(res.size() == 0){
            res.add(Integer.parseInt(expression.substring(left, right + 1)));
        }
    
        return res;
    }
}
