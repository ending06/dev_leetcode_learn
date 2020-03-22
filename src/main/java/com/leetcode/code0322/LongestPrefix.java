package com.leetcode.code0322;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// 最长快乐前缀
// -------------------------------------------------------

public class LongestPrefix {

/*
   //62超时
   public static String longestPrefix(String s) {
        if(s.length()==0||s.length()==1){
            return "";
        }

        int max = 0;
        String finalString = "";

        for(int i=1;i<s.length();i++){
            String prefix = s.substring(0,i);
            String suffix = s.substring(s.length()-i,s.length());
            if(prefix.equals(suffix)){
                if(prefix.length()>max){
                    max = prefix.length();
                    finalString = prefix;
                }
            }
        }
        return finalString;
    }*/

/*
       // 67超时
       public static String longestPrefix(String s) {

        Character end = s.charAt(s.length()-1);

        int i = 0;
        String finalString = "";

        while(i<s.length()-1){
            if(s.charAt(i)!=end){
                i++;
                continue;
            }

            String prefix = s.substring(0,i+1);
            String sufix = s.substring(s.length()-1-i,s.length());
            if(prefix.equals(sufix)){
                finalString = prefix;
            }
            i++;
        }
        return finalString;
    }*/


    public static String longestPrefix(String s) {

        Character end = s.charAt(s.length()-1);

        int i = s.length()-2;
        String finalString = "";

        while(i>=0){
            if(s.charAt(i)!=end){
                i--;
                continue;
            }

            String prefix = s.substring(0,i+1);
            String sufix = s.substring(s.length()-1-i,s.length());
            if(prefix.equals(sufix)){
                finalString = prefix;
                break;
            }
            i--;
        }
        return finalString;
    }

    public static void main(String[] args) {
/*        String aa = "level";

        String result = longestPrefix(aa);

        System.out.println("===>"+result);


        String bb = "ababab";

        String result2 = longestPrefix(bb);

        System.out.println("===>"+result2);


        String cc = "leetcodeleet";

        String result3 = longestPrefix(cc);

        System.out.println("===>"+result3);*/


/*        String dd = "a";

        String result4 = longestPrefix(dd);

        System.out.println("===>"+result4);*/


        String zz = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result5 = longestPrefix(zz);
        System.out.println("===>"+result5);

    }
}