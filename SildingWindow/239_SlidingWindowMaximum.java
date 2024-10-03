//Leetcode URL - https://leetcode.com/problems/sliding-window-maximum/description/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int currMax = nums[0];
        int i = 0;
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        while(j < n){
            //!!!!!! - visualize and draw on paper.
            while(!dq.isEmpty() && dq.peekLast() < nums[j]){
                dq.removeLast();
            }
            dq.add(nums[j]); //used to add an element at the tail of the queue
            currMax = dq.peekFirst();
            // System.out.println(dq);
            if(j - i + 1 == k){
                res[i] = currMax;
                // removing an element at start;
                // check if its the currMax! and if?
                // ...if we are removing the currMax, then should update the max with next maximum
                // how are you going to find it optimally!! 

                // Maintain a deque -> with head having max and then next max ..soo on, 
                // according to index, if a new max arrives, place it accordingly in the queue and remove the values that doesn't matter

                if(nums[i] == currMax){
                    dq.removeFirst();
                }
                i++;
            }

            j++;
        }

        return res;
    }
}
