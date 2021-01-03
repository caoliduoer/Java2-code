package shujiazuoye;

/*
* i am a student 逆置为Student a am i;
* */
public class Reverse {
    public static void main(String[] args) {
        String str="I am a Student";
        System.out.println(reverse(str));
    }

    private static String  reverse(String str) {
        String[] st=str.split(" ");
        String str1="";

        int i=st.length-1;
        while(i>=0){
            if(i!=0){
            str1=str1+st[i]+" ";}
            else{
                str1=str1+st[i];
            }
            i--;
        }
        return str1;
    }
}
