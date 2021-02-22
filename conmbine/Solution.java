package conmbine;

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
     //合并连个有序链表
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head=new ListNode(-1);
        ListNode cur=head;

        while(list2!=null&&list1!=null){
            if(list2.val>list1.val){
                cur.next=list1;
                list1=list1.next;
                cur=cur.next;
            }else{
                cur.next=list2;
                list2=list2.next;
                cur=cur.next;
            }
        }
        if(list2==null){
            cur.next=list1;
        }else {
            cur.next=list2;
        }
        return head.next;

    }
}
