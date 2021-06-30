package day8;


 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
import java.util.ArrayList;
public class Solution {
    ArrayList<TreeNode> list=new ArrayList<>();
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
        if(pRootOfTree!=null){
            Convert(pRootOfTree.left);
            list.add(pRootOfTree);
            Convert(pRootOfTree.right);

        }
        return list;

    }
}
