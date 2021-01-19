package javaScript.LinkedList;
import java.util.*;

public class Devide {
        public ListNode head;
        public ListNode partition(ListNode pHead, int x) {
            // write code here
            ListNode newHead=null;
            ListNode head=null;
            ListNode cur=pHead;
            ListNode newCur1=newHead;
            ListNode newCur2=head;
            while(cur!=null){
                if(cur.val>=x){
                    if(head==null){
                        head=cur;
                        newCur1=head;
                        //newCur1.next=null;
                    }else{
                        newCur1.next=cur;
                        newCur1=cur;
                       // newCur1.next=null;
                    }
                }else{
                    if(newHead==null){
                        newHead=cur;
                        newCur2=newHead;
                        //newCur2.next=null;
                    }else{
                        newCur2.next=cur;
                        newCur2=cur;
                        //newCur2.next=null;
                    }
                }
                cur=cur.next;
            }

            if(head==null){
                return newHead;
            }if(newHead==null){
                return head;
            }else{
                newCur2.next=head;
                return newHead;
            }
        }
    public void add(int val){
            ListNode node=new ListNode(val);

        if(head==null){
            head=node;
        }else {
            ListNode cur=head;
            while(cur.next!=null){
               cur= cur.next;
            }
            cur.next=node;
        }
    }
    public static void main(String[] args) {
        Devide d=new Devide();
        d.add(1);
        d.add(3);
        d.add(9);
        d.add(2);
        d.partition(d.head,2);
    }
}
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
