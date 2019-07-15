//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//说明:
//1 ≤ m ≤ n ≤ 链表长度。
//示例:
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean stop;
    private ListNode left;
    public void reverse(ListNode right,int m,int n){
        if (n == 1) {
            return;
        }
        right = right.next;
        if(m>1){
            this.left=this.left.next;
        }
        this.reverse(right,m-1,n-1);
        if(this.left==right||this.left==right.next){
            this.stop=true;
        }
        if(!this.stop){
            int val = this.left.val;
            this.left.val = right.val;
            right.val=val;
            this.left=this.left.next;

        }

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.reverse(head, m, n);
        return head;
    }
}