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
    private ListNode start;
    public boolean isPalindrome(ListNode head) {
        ListNode end = head;
        start = head;
        return back(end);
    }
    private boolean back(ListNode end){ //先通过遍历到链表尾部，然后总后往前遍历，和start节点的val进行匹配，其中start节点是从前往后遍历，判断start.val, end.val是否相等，从而判断isPalindrome是否为回文串
        if(end == null){ // 先让end遍历到结尾
            return true;
        }
        if(!back(end.next)){
            return false;
        }
        if(end.val!=start.val){ // 判断
            return false;
        }
        start = start.next; // start往后移
        return true;
    }
}
