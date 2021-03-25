package Try.treetoArray;
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
    //private static ArrayList<TreeNode> list;
   public static ArrayList<TreeNode> list;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> list=getAll(pRootOfTree);
        if(list.size()==0){
            return null;
        }
        TreeNode root=list.get(0);
        TreeNode cur=root;
        for(int i=1;i<list.size();i++){
            TreeNode node=list.get(i);
            node.left=cur;
            cur.right=node;
            cur=node;
        }
        return root;
    }
    public  ArrayList<TreeNode> getAll(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }

        Convert(pRootOfTree.left);
        list.add(pRootOfTree);
        Convert(pRootOfTree.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        TreeNode node1=new TreeNode(6);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(3);
        root.right=node1;
        root.left=node2;
        node2.left=node3;
        Solution s=new Solution();
        s.Convert(root);
    }

}