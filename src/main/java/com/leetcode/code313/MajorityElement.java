package com.leetcode.code313;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-13<p>
// 找出出现次数大于n/2的元素
// -------------------------------------------------------

public class MajorityElement {
    private static int DEFAULT = -1;

    /**
     * 任意找出两个不同的数，删除；剩下的即是大于n/2的数据
     */
    public static int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == DEFAULT) {
                continue;
            }
            int differentIndex = find(nums, nums[i]);
            if (differentIndex == Integer.MIN_VALUE) {
                break;
            } else {
                nums[i] = DEFAULT;
                nums[differentIndex] = DEFAULT;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != DEFAULT) {
                return nums[i];
            }
        }
        return DEFAULT;
    }

    private static int find(int[] nums, int init) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != init && nums[i] != DEFAULT) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 8, 7, 7, 7 };
        int result = majorityElement(nums);
        System.out.println("===>" + result);
    }
}