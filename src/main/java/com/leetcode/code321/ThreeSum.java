package com.leetcode.code321;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-21<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){

                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));

                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                }
                else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };

        int[] nums2= new int[]{1,-1,-1,0};

        int[] nums3 = new int[]{7,-10,7,3,14,3,-2,-15,7,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15};


        int[] nums4 = new int[]{-1,0,1,2,-1,-4};
        System.out.println("===>" + threeSum(nums4));
    }
}