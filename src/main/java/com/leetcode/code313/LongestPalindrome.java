package com.leetcode.code313;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-13<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        char[] revert = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            revert[i] = s.charAt(s.length() - i - 1);
        }

        List<Character> finalValue = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != revert[i]) {
                continue;
            }
            List<Character> tempList = findSame(i, revert, s);

            if (tempList.size() >= finalValue.size()) {
                finalValue.clear();
                finalValue.addAll(tempList);
                tempList.clear();
            }
        }

        if (finalValue.size() == 0) {
            return String.valueOf(s.charAt(0));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalValue.size(); i++) {
            result.append(finalValue.get(i));
        }
        return result.toString();
    }

    private static List<Character> findSame(int i, char[] revert, String s) {
        List<Character> tempList = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            if (revert[j] == s.charAt(j)) {
                tempList.add(s.charAt(j));
            }
        }
        return tempList;
    }

    public static void main(String[] args) {
        // String aa = "babad";
        // String aa = "ac";
        String aa = "abb";
        String result = longestPalindrome(aa);
        System.out.println("===>" + result);
    }
}