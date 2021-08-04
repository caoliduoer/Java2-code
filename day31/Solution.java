package day31;

import java.util.*;

 class TreeNode {
   int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
  }

public class Solution {
    /**
     *
     * @param //root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public static void main(String[] args) {
        Solution s=new Solution();
        TreeNode root=new TreeNode(1);
        TreeNode node=new TreeNode(2);
        root.right=node;
        System.out.println(s.levelOrder(root));
    }
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        Queue<TreeNode> queue=new LinkedList<TreeNode>() {
        };
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        if(root==null){
            return res;
        }
        queue.add(root);


        while(!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                int a=node.val;
                list.add(a);
            }res.add(list);

        }
        return res;
    }
}