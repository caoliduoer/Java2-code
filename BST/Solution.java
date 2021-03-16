package Try.BST;

/*
*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
* （ps：我们约定空树不是二叉搜素树）
* */
public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {
        //二叉搜索树的特点，每个根节点都满足：节点的左子树都小于等于节点的值；节点的右子树都大于根节点的值
        //int index=sequence.length-1;
        if(sequence.length == 0){
            return false;
        }
        return traverse(sequence,0,sequence.length-1);

    }
    public boolean traverse(int[] sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int key=sequence[end];
        int i=0;
        for( i=start;i<end;i++){
            if(sequence[i]>key)
                break;
        }
        for(int j=i;j<end;j++){
            if(sequence[j]<key){
                return false;
            }
        }
        return traverse(sequence,start,i-1)&&traverse(sequence,i,end-1);//在子树中遍历，除去根节点
    }

}