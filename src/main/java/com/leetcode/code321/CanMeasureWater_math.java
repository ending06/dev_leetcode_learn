package com.leetcode.code321;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// -------------------------------------------------------

public class CanMeasureWater_math {

    public static boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcb(x, y) == 0;
    }

    private static int gcb(int m, int n) {
        // 保证m>n,若m<n,则进行数据交换
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        // 若余数为0,返回最大公约数
        if (m % n == 0) {
            return n;
        } else {
            // 否则,进行递归,把n赋给m,把余数赋给n
            return gcb(n, m % n);
        }
    }


    public static void main(String[] args) {
        System.out.println("===>"+canMeasureWater(3,5,4));

        System.out.println("===>"+canMeasureWater(2,6,5));
    }
}