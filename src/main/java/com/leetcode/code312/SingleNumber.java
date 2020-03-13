package com.leetcode.code312;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-12<p>
// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
// -------------------------------------------------------

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int numInit = 0;
        for (int i = 0; i < nums.length; i++) {
            numInit = numInit ^ nums[i];
        }
        return numInit;
    }
}