//删除链表中等于给定值 val 的所有节点。
//示例:
//输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
/**
 * 时间复杂度O(N)，空间复杂度O(1)
 * 需要考虑的情况有
 * （1）链表为空
 * （2）链表中仅有一个元素
 * （3）删除头结点
 * 考虑引入虚拟头结点解决上述情况
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //创建一个虚拟头结点
        ListNode dummyNode=new ListNode(val-1);
        dummyNode.next=head;
        ListNode prev=dummyNode;
        //确保当前结点后还有结点
        while(prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return dummyNode.next;
    }
}