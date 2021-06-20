package day5;
import java.util.ArrayList;

import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s=new Stack<>();
        int i=0;
        int j=0;
        while(i<pushA.length&&j<popA.length){
            if(pushA[i]!=popA[j]){
                s.push(pushA[i]);
                i++;
            }else{
                s.push(pushA[i]);
                s.pop();
                i++;
                j++;
                while(!s.isEmpty()&&s.peek()==popA[j]){
                    s.pop();
                    j++;
                }
            }
        }
        if(i==pushA.length&&s.isEmpty()){
            return true;
        }
        return false ;
    }

    public static void main(String[] args) {

    }
}