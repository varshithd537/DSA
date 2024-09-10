//Leetcode Url - https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/

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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = head;

        ListNode dup = head;
        ListNode prev = head;
        int a = -1;
        int b = -1;

        while(dup != null && dup.next != null){
            a = dup.val;
            prev = dup;

            b = dup.next.val;
  
            int gcd = getGcd(a,b);
            ListNode temp = prev.next;
            prev.next = new ListNode(gcd);
            prev = prev.next;
            prev.next = temp;

            dup = dup.next.next;
        }

        return res;
    }

    public int getGcd(int a, int b) {
        if (b==0) return a;
        return getGcd(b,a%b);
    }
}
