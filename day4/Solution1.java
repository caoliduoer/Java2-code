package day4;

import java.util.Stack;

public class Solution1 {

    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public void push(int node) {

        s1.push(node);
        if(s2.empty()){//第一次需要判断一下
            s2.push(node);

        }
        else{
            if(node<s2.peek()){
                s2.push(node);

            }
            else {
                s2.push(s2.peek());
            }
        }


    }
    public void pop() {
        s1.pop();
        s2.pop();
    }
    public int top() {
        return s1.peek();
    }
    public int min() {
        return s2.peek();
    }

    public static void main(String[] args) {
        
    }
}