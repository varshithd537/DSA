//Leetcode URL - https://leetcode.com/problems/split-linked-list-in-parts/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode dup = head;
        int N = 0;
        while(dup != null){
            N++;
            dup = dup.next;
        }
        //If there are N nodes in the list, and k parts, then every part has N/k elements, 
        //except the first N%k parts have an extra one.
        int split = N/k;
        int extra = N%k;

        dup = head;

        int i = 0;
        int j = 0;
        for(; i < N; ){
            if(dup == null){
                break;
            }
            ListNode prev = dup;

            int count = 0;
            res[j] = prev;
            
            while(count < split){
                prev = dup;
                dup = dup.next;
                // prev = prev.next;
                count++;
                i++;
            }
            if(j < extra){
                prev = dup;
                dup = dup.next;
                // prev = prev.next;
                i++;
            }
            j++;
            // System.out.println(i+" "+prev.val);
            // prev.next = null;
            if(prev != null){
                prev.next = null;
            }

        }

        return res;
    }
}
