package day7;

import java.util.ArrayList;

  class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
public class Solution {
    public ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public ArrayList<Integer> list=new ArrayList<>();
    public boolean flag=false;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(root==null){
            return res;
        }
        Find(root,target,0);
        return res;
    }
    public void Find(TreeNode root,int target,int sum){
        if(flag==true){
            list.remove(list.size()-1);
            flag=false;
        }
        if(root==null||sum+root.val>target){
            return;
        }
        if(root.left==null&&root.right==null){//叶子节点
            if(root.val+sum==target){
                list.add(root.val);
                res.add(new ArrayList(list));
                list.remove(list.size()-1);
                flag=true;
                return;

            }else{
                if(root.val+sum<target){

                    return;
                }
            }
        }
        else{
            list.add(root.val);
        }

        if(root.left!=null){
            Find(root.left,target,sum+root.val);
        }
        if(root.right!=null){
            Find(root.right,target,sum+root.val);
        }
    }
}