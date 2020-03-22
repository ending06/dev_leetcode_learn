package com.leetcode.code321;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-21<p>
// 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列
//-------------------------------------------------------

public class Zconvert {


    public static class Element{
        private int[][] store;

        public Element(int rows) {
            this.store = new int[rows][rows-1];
        }
    }
}