package badKeyBoard.isPopStack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    private List<Integer>intArrayToList(int[] array){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        return list;
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        List<Integer> pushList=intArrayToList(pushA);
        List<Integer>popList=intArrayToList(popA);
        Deque<Integer> stack=new LinkedList<>();
        while(!popList.isEmpty()){
            int p=popList.remove(0);
            while(true){
                if(stack.size()==0|| stack.peek() !=p){
                    if(pushList.isEmpty()){
                        return false;
                    }
                    int q=pushList.remove(0);
                    stack.push(q);
                }else{
                    break;
                }
            }
            stack.pop();
        }
        return stack.isEmpty();
    }
}