package com.leetcode.code38;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-08<p>
// 生成奇数字母组成的字符串
// 生成长度为 n 字符串，其中每个字母的个数都是奇数个
//-------------------------------------------------------

public class GenerateString {

    public static String generateString(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("param n must be more than zero");
        }
        //偶数
        if (n % 2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<n-1;i++){
                stringBuilder.append("a");
            }
            stringBuilder.append("b");
            return stringBuilder.toString();
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<n;i++){
                stringBuilder.append("a");
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args){
        String result = generateString(4);
        System.out.println("==>"+result);
    }
}