//Leetcode Url - https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode res = new ListNode(0);
        ListNode dup = res;

        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            set.add(num);
        }

        while(head != null){
            if(set.contains(head.val)){
                head = head.next;
            }
            else{
                dup.next = head;
                dup = dup.next;
                // ------- !!!
                head = head.next;
                dup.next = null;
            }
        }

        return res.next;
    }
}
