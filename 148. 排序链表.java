// 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

// 示例 1:

// 输入: 4->2->1->3
// 输出: 1->2->3->4
// 示例 2:

// 输入: -1->5->3->4->0
// 输出: -1->0->3->4->5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // 时间复杂度要求O(NlogN)，自然想到使用二分法，从而采用归并排序，链表可断开再连接的性质使得空间复杂度保持为O(1)
 // 利用快慢指针使得链表从中间位置断开，直到每个链表中只有一个元素，再依次从下向上进行两两之间合并排序
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode newList = new ListNode(0);
        ListNode h = newList;
        while(left!=null&&right!=null){
            if(left.val>right.val){
                newList.next = right;
                right = right.next;
            }else{
                newList.next = left;
                left = left.next;
            }
            newList = newList.next;
        }
        newList.next = left != null ? left:right;
        return h.next;
    }
}
