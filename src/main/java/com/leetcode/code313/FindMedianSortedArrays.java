package com.leetcode.code313;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-13<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return medianNumber(toSort(toList(nums2)));
        }
        if (nums2 == null) {
            return medianNumber(toSort(toList(nums1)));
        }
        List<Integer> allList = new ArrayList<>(nums1.length + nums2.length);
        allList.addAll(toList(nums1));
        allList.addAll(toList(nums2));
        return medianNumber(toSort(allList));
    }

    private static List<Integer> toSort(List<Integer> allList) {
        Collections.sort(allList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        return allList;
    }

    private static List<Integer> toList(int[] nums1) {
        List<Integer> list = new ArrayList<>(nums1.length);
        for(int i=0;i<nums1.length;i++){
            list.add(nums1[i]);
        }
        return list;
    }

    private static double medianNumber(List<Integer> list) {
        int length = list.size();
        if (length % 2 == 0) {
            return (list.get(length / 2 - 1) + list.get(length / 2)) / 2.0;
        }
        return (double)list.get(length / 2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println("===>"+result);
    }
}