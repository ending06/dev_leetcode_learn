package com.leetcode.code39;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-09<p>
//1365. 有多少小于当前数字的数字
//-------------------------------------------------------

public class smallerNumberThanCurrent {

    //TODO 可优化，耗时长
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    total++;
                }
            }
            result[i] = total;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] init = {8, 1, 2, 2, 3};
        int[] result = smallerNumbersThanCurrent(init);
        System.out.println("===>" + result);
    }
}