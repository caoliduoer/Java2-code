package reverseLinkedList;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode cur=listNode;
        ArrayList<Integer> list=new ArrayList<>();
        int[] arr=new int[1000];
        int i=0;
        while(cur!=null){
            arr[i]=cur.val;
            i++;
            cur=cur.next;
        }
        for(int j=i-1;j>=0;j--){
            list.add(arr[j]);
        }
        return list;
    }
}
 class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
           this.val = val;
        }
    }
