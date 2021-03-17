package Try.findPath;

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
    private ArrayList<ArrayList<Integer>> endlist=new ArrayList<>();//成员变量
    private ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //ArrayList<Integer> list=new ArrayList<>();

        //findPath(root,target);
        if(root==null){//如果到了叶子节点之后，就返回链表
            return endlist;
        }
        list.add(root.val);//否则添加
        target-=root.val;//还剩的数字
        if(target==0&&root.left==null&&root.right==null){
            endlist.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return endlist;
    }

}