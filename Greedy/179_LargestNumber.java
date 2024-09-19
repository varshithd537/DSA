//LeetCode URL - https://leetcode.com/problems/largest-number/description

class Solution {
    public String largestNumber(int[] nums) {
        //Need to solve it in more optimal methods - Given in Editorial!!
        
        //.....1.HeapSort!!
        //The trick here is to compare the concatenation along with the traditional sorting.
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (b + a).compareTo(a + b));

        int len = 0;

        for(int num : nums){
            String str = Integer.toString(num);
            len += str.length();
            pq.offer(str);
        }

        StringBuilder sb = new StringBuilder(len);
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }

        //Handling the edge case with zeroes;
        if(sb.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }
}
