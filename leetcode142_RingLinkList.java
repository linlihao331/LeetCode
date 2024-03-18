// leetcode 142 环形链表II

// 方法：快慢双指针链表

// 思路：
// 入圈的第一个结点：res，相遇结点：meet
// 入圈前的距离为：a，圈周长：b
// 当slow到达res，slow走了a步，fast走了2a步，slow距离fast的长度为a−Nb步，fast距离slow的长度为(N+1)b−a步。
// 当fast追上slow时，slow又走了(N+1)b−a步
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do{
            if(fast == null || (fast.next==null)){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while(fast!=slow);
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
