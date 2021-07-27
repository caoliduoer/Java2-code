package day25;

import java.util.*;

 class TreeNode {
   int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 }

public class Solution {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public ArrayList<Integer> list=new ArrayList<>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] arr=new int[3][];
        preTraver(root);
        midTraver(root);
        endTraver(root);
        int len=list.size()/3;
        int k=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<len;j++){
                arr[i][j]=list.get(k);
            }
        }
        return arr;
    }
    public void preTraver(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        preTraver(root.left);
        preTraver(root.right);
    }
    public void midTraver(TreeNode root){
        if(root==null){
            return;
        }
        midTraver(root.left);
        list.add(root.val);
        midTraver(root.right);
    }
    public void endTraver(TreeNode root)
    {
        if(root==null){
            return;
        }
        endTraver(root.left);
        endTraver(root.right);
        list.add(root.val);
    }
}