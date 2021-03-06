package Try.copyLinkedList;
import java.util.*;
/*
* 题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
* 另一个特殊指针random指向一个随机节点），
* 请对此链表进行深拷贝，并返回拷贝后的头结点。
* （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*
* */
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        RandomListNode cur=pHead;
        RandomListNode newHead=new RandomListNode(cur.label);
        RandomListNode p=newHead;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();

        //RandomListNode next1=null;
        RandomListNode pre=null;
        while(pHead!=null){
            map.put(pHead,new RandomListNode(pHead.label));
            pHead=pHead.next;

        }
        while(cur!=null){
            p.next=map.get(cur.next);
            p.random=map.get(cur.random);
            cur=cur.next;
            p=p.next;

        }
        return newHead;
    }
}