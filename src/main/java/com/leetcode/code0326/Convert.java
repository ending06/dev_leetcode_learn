package com.leetcode.code0326;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-26<p>
// -------------------------------------------------------

public class Convert {

    public static String convert(String s, int numRows) {
        Element element = new Element(numRows,s);
        return "";
    }

    private static class Element {
        private int[][] data = null;
        // 起始位置
        private int start;
        // 结束位置
        private int end;

        public Element(int numRows,String s) {

            int[][] data = new int[numRows][numRows - 1];
            int i = data.length;
            int j = data[0].length;
            System.out.println("i===>"+i+";j====>"+j);
        }
    }

    public static void main(String[] args) {
        String aa = "LEETCODEISHIRING";
        String result1 = convert(aa, 3);
        // LCIRETOESIIGEDHN
        System.out.println("===>" + result1);

        String bb = "LEETCODEISHIRING";
        String result2 = convert(bb, 4);
        // LDREOEIIECIHNTSG
        System.out.println("====>" + result2);

    }
}