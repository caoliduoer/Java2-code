package day4;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Solution {

    //public ArrayList<Integer> lsit;
    public Stack<Integer> s=new Stack<>();
    public Queue<Integer> que = new LinkedList<Integer>();
    public int min=Integer.MAX_VALUE;
    public void push(int node) {
        s.push(node);
        //que.add(node);
    }

    public void pop() {
        if(s.isEmpty()){
            que.poll();
        }
        else{
            s.pop();
        }

    }

    public int top() {
        if(s.isEmpty()){
            return que.peek();
        }
        return s.peek();
    }

    public int min() {
        //int min=Integer.MAX_VALUE;
        if(s.isEmpty()){
            return min;
        }
        while(!s.isEmpty()){
            int temp=s.pop();
            if(temp<min){
                min=temp;
            }
            que.add(temp);
        }
        return min;
    }
}
