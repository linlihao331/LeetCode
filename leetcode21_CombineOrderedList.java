// leetcode 21 合并两个有序链表

// 方法：递归

// 思路： 合并两个已排序的单链表list1和list2，并返回合并后的链表头。方法的基本思路是比较两个链表当前节点的值，选择较小的节点作为合并后链表的当前节点，然后递归地继续合并剩余部分。

//       基础情况处理：
//       如果list1为空，意味着list2中剩余所有节点都大于等于已合并链表中的所有节点，因此可以直接将list2剩余部分链接到合并链表的末尾，返回list2。
//       同样，如果list2为空，意味着list1中剩余所有节点都大于等于已合并链表中的所有节点，因此可以直接将list1剩余部分链接到合并链表的末尾，返回list1。

//       递归合并：
//       如果list1的当前节点值小于list2的当前节点值，则list1的当前节点应该在合并后的链表中的当前位置。因此，将list1.next设置为mergeTwoLists(list1.next, list2)的返回值，意味着递归地合并list1的下一个节点和list2，然后返回list1。
//       否则（即list2的当前节点值小于或等于list1的当前节点值），将list2.next设置为mergeTwoLists(list1, list2.next)的返回值，意味着递归地合并list1和list2的下一个节点，然后返回list2。


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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){ // 如果list1空了，剩下的链表就是list2，所以返回剩下的list2
            return list2;
        }
        if(list2 == null){ // 如果list2空了，剩下的链表就是list1，所以返回剩下的list1
            return list1;
        }
        if(list1.val<list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
