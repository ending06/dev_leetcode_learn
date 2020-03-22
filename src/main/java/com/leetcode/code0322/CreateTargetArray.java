package com.leetcode.code0322;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// -------------------------------------------------------

import java.util.Arrays;

public class CreateTargetArray {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] array = new int[index.length];
        for (int i = 0; i < index.length; i++) {
            array[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < index.length; i++) {
            if (array[index[i]] == Integer.MIN_VALUE) {
                array[index[i]] = nums[i];
            }else {
                copy(array,index[i],nums[i]);
            }
        }
        return array;
    }

    public static void copy(int[] array, int index, int num) {

        // 循环将数字后移
        for (int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }

        // 将指定数字放到指定下标上
        array[index] = num;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[]{0,1,2,2,1};

        //int[] nums = new int[]{1,2,3,4,0};
        //int[] index = new int[]{0,1,2,3,0};

        //int[] nums = new int[]{1};
        //int[] index = new int[]{0};

        //int[] nums = new int[] { 4, 2, 4, 3, 2 };
        //int[] index = new int[] { 0, 0, 1, 3, 1 };
        int[] target = createTargetArray(nums, index);
        System.out.println("===>" + target);
    }
}