package Message;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> list=new ArrayList<>();
        char[] c1=ransomNote.toCharArray();
        char[] c2=magazine.toCharArray();
        for(int i=0;i<ransomNote.length();i++){
            for(int j=0;j<magazine.length();j++){
                if(c1[i]==c2[j]){

                    list.add(c1[i]);


                }
            }
        }
        if(list.size()==c1.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        s.canConstruct("abc","abc");
    }
}