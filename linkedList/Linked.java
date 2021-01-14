package shujiazuoye.linkedList;

import javax.swing.plaf.IconUIResource;

/*
* 不带头结点的单链表
* */
public class Linked {
    private Node head;

    /*
    * 添加节点（头插）
    * */
    public void add(int key){
        Node node=new Node(key);
        if(head==null){
            head=node;
        }else{
           node.next=head;
           head=node;
        }
    }
    /*
    * 尾插
    * */
    public void addLast(int key){
        Node node=new Node(key);
        Node current=this.head;
        Node pre=null;
        while (current!=null){
            pre=current;
            current=current.next;
        }
        pre.next=node;
    }

    /*
    * 排序插入:从小到大
    * */
    public void insert(int key){
        Node node=new Node(key);

        Node current=this.head;
        Node pre=current;
        if(this.head==null){
            head=node;
        }else{
            while (current!=null){
                if(current.key>key){
                    break;
                }else{
                    pre=current;
                    current=current.next;
                }
            }
            if(current==this.head){
                add(key);//头插
            }else if(current==null){
                addLast(key);//尾插
            }else{//中间节点
                pre.next=node;
                node.next=current;
            }


        }
    }
/*
* 链表的大小长度
* */
    public int size(){
        int size=0;
        Node node=this.head;
        while (node!=null){
            node=node.next;
            size++;
        }
        return size;
    }
    /*
    * 删除节点
    * */
    public boolean remove(int key){
        Node node=this.head;
        Node pre=node;
        while (node!=null){
            if(node.key==key){
                if(node.next==null){
                    pre.next=null;
                }else if(node==head){
                    head=head.next;
                }
                else{
                    pre.next=node.next;
                }
                return true;
            }
            pre=node;
            node=node.next;

        }
        return false;
    }
    /*
    * 得到头结点
    * */
    public Node getHead(){
        return this.head;
    }
    /*
    * 得到第几个元素
    * */
    public Node get(int index){
        int count=1;
        Node node=this.head;
        while (node!=null&&count<index){
            node=node.next;
            count++;
        }
        if(node==null){//这个下标不存在
            return null;
        }else{
            //下标找到
            return node;
        }
    }
    /*
    * 删除第index个节点（节点下标从0开始）
    * */
    public boolean removeIndex(int index){
        //int count=1;
        if(index>this.size()){
            return  false;
        }
        if(index==1){//删除头结点
            head=head.next;
            return true;
        }
        Node node=this.head;
        Node pre=null;
        for (int i = 1; i <index; i++) {
            pre=node;
            node=node.next;
        }
        pre.next=node.next;
        return true;
    }
    /*
    * 删除倒数第k个节点，并且返回该链表的头结点
    * */
    public boolean removeLastIndex(int key){
        int index=this.size()-key+1;
        if(index>0&&index<this.size()){
            return this.removeIndex(index);
        }
        return false;
    }
}
