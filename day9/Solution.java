package day9;
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
    public TreeNode pre=null;
    public TreeNode head=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Convert(pRootOfTree.left);
        if(pre!=null){
            pre.right=pRootOfTree;
            pRootOfTree.left=pre;
        }
        pre=pRootOfTree;
        if(head==null){
            head=pre;
        }
        Convert(pRootOfTree.right);
        return head;
    }




}