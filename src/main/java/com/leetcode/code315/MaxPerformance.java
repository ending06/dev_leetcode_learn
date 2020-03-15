package com.leetcode.code315;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-15<p>
// n = 6, speed = [2,10,3,1,5,8],
//        efficiency = [5,4,3,9,7,2],
//        k = 2
// (10 + 5) * min(4, 7) = 60
// -------------------------------------------------------

public class MaxPerformance {

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[] dp = new int[n];
        return 0;
    }

    public static void main(String[] args) {
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 };
        int[] efficiency = new int[] { 5, 4, 3, 9, 7, 2 };

        int result = maxPerformance(6, speed, efficiency, 2);
        System.out.println("===>" + result);
    }
}