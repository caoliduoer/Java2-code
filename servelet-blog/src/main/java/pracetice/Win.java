package pracetice;

import java.util.Scanner;
import java.util.*;
public class Win{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String num=sc.nextLine();
        int n=Integer.parseInt(num);
        TreeMap<Character,Integer> mapa=new TreeMap<>();
        TreeMap<Character,Integer> mapb=new TreeMap<>();
        int a=0;//a胜
        int b=0;//a平
        int c=0;//a败
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            if(s.charAt(0)=='C'){
                if(s.charAt(2)=='J'){
                    a++;
                    if(mapa.get('C')==null){
                        mapa.put('C',1);
                    }else{
                        int tem=mapa.get('C');
                        mapa.put('C',++tem);
                    }
                }else if(s.charAt(2)=='C'){
                    b++;
                }else{
                    c++;
                    if(mapb.get('B')==null){
                        mapb.put('B',1);
                    }else{
                        int tem=mapa.get('B');
                        mapa.put('B',++tem);
                    }
                }
            }
            else if(s.charAt(0)=='J'){
                if(s.charAt(2)=='C'){
                    c++;
                    if(mapb.get('C')==null){
                        mapb.put('C',1);
                    }else{
                        int tem=mapa.get('C');
                        mapa.put('C',++tem);
                    }
                }
                else if(s.charAt(2)=='J'){
                    b++;
                }else{
                    a++;
                    if(mapa.get('J')==null){
                        mapa.put('J',1);
                    }else{
                        int tem=mapa.get('J');
                        mapa.put('J',++tem);
                    }
                }
            }else{
                if(s.charAt(2)=='C'){
                    a++;

                    if(mapa.get('B')==null){
                        mapa.put('B',1);
                    }else{
                        int tem=mapa.get('B');
                        mapa.put('B',++tem);
                    }
                }else if(s.charAt(2)=='B'){
                    b++;
                }
                else{
                    c++;
                    if(mapb.get('J')==null){
                        mapb.put('J',1);
                    }else{
                        int tem=mapa.get('J');
                        mapa.put('J',++tem);
                    }
                }
            }

        }
        System.out.println(a+" "+b+" "+c);
        System.out.println(c+" "+b+" "+a);
        int max=0;
        char ch=' ';
        for(char c1:mapa.keySet()){
            if(mapa.get(c1)>max){
                ch=c1;
            }
        }
        System.out.print(ch+" ");
        for(char c1:mapb.keySet()){
            if(mapb.get(c1)>max){
                ch=c1;
            }
        }
        System.out.println(ch);
    }
}