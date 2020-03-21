package com.leetcode.code321;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-21<p>
// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ThreeSum_TimeOut {

    private static List<List<Integer>> result = new ArrayList<>();

    private static final int k_count = 3;

    public static List<List<Integer>> threeSum(int[] nums) {
        result.clear();

        List<Integer> current = new ArrayList<Integer>(nums.length);

        find(0, current, nums, 3);
        return result;
    }

    private static void find(int index, List<Integer> currentList, int[] nums, int k) {
        if (index == nums.length) {
            if (currentList.size() == k_count) {
                System.out.println("currentList===>" + currentList);
                System.out.println("result===>" + result);
                compute(currentList);
            }
            return;
        }
        if (k == 0) {
            // 计算当前currentList中的值是否满足要求
            compute(currentList);
            return;
        }

        List<Integer> tempList = new ArrayList<>(currentList);

        currentList.add(nums[index]);

        find(index + 1, currentList, nums, k - 1);

        find(index + 1, tempList, nums, k);
    }

    private static void compute(List<Integer> currentList) {
        int sum = 0;
        Collections.sort(currentList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < currentList.size(); i++) {
            sum = sum + currentList.get(i);
            tempList.add(currentList.get(i));
        }
        if (sum == 0) {
            if (isNewResult(tempList, result)) {
                result.add(tempList);
            }
        }
    }

    private static boolean isNewResult(List<Integer> tempList, List<List<Integer>> result) {
        for(List<Integer> key:result){
            boolean isEqual = isEqual(tempList,key);
            if(isEqual){
                return false;
            }
        }
        return true;
    }

    private static boolean isEqual(List<Integer> tempList, List<Integer> key) {

        for(int i=0;i<tempList.size();i++){
            if(!key.get(i).equals(tempList.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };

        int[] nums2= new int[]{1,-1,-1,0};

        int[] nums3 = new int[]{7,-10,7,3,14,3,-2,-15,7,-1,-7,6,-5,-1,3,-13,6,-15,-10,14,8,5,-10,-1,1,1,11,6,8,5,-4,0,3,10,-12,-6,-2,-6,-6,-10,8,-5,12,10,1,-8,4,-8,-8,2,-9,-15,14,-11,-1,-8,5,-13,14,-2,0,-13,14,-12,12,-13,-3,-13,-12,-2,-15,4,8,4,-1,-6,11,11,-7,-12,-2,-8,10,-3,-4,-6,4,-14,-12,-5,0,3,-3,-9,-2,-6,-15,2,-11,-11,8,-11,8,-7,8,14,-5,4,10,3,-1,-15,10,-6,-11,13,-5,1,-15};
        System.out.println("===>" + threeSum(nums3));

    }
}