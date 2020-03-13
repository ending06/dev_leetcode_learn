package com.leetcode.code313;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-13<p>
// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        List<Character> tempList = new ArrayList<>(s.length());
        for (int i=0; i < s.length(); i++) {
            tempList.add(s.charAt(i));

            for (int j=i+1;j<s.length();j++) {

                if (tempList.contains(s.charAt(j))) {
                    if(tempList.size()>=max){
                        max = tempList.size();
                    }
                    tempList.clear();
                    break;
                }else{
                    tempList.add(s.charAt(j));
                }
            }
            if(tempList.size()>=max){
                max = tempList.size();
            }
            tempList.clear();
        }
        return max;
    }

    public static void main(String[] args) {
        //String aa = "abcabcbb";
        //String aa = "bbbbb";
        String aa = "pwwkew";
        int result = lengthOfLongestSubstring(aa);
        System.out.println("===>" + result);
    }
}