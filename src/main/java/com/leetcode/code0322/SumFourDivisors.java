package com.leetcode.code0322;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class SumFourDivisors {

    public static int sumFourDivisors(int[] nums) {
        int sum = 0;
        List<Integer> factors = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            divisors(nums[i], factors);
            if (factors.size() == 4) {
                sum = sum+ sum(factors);
            }
            factors.clear();
        }
        return sum;
    }

    private static int sum(List<Integer> factors) {
        int sum = 0;
        for (int i = 0; i < factors.size(); i++) {
            sum = sum + factors.get(i);
        }
        return sum;
    }

    /**
     * 分解因子
     */
    private static void divisors(int num, List<Integer> factors) {
        int i=1;
        boolean isJiData = (num%2!=0);
        while(i<Math.sqrt(num)){
            if (factors.contains(i)) {
                continue;
            }
            if (num % i == 0) {
                if (!factors.contains(i)) {
                    factors.add(i);
                }
                if (!factors.contains(num / i)) {
                    factors.add(num / i);
                }
            }
            if(isJiData){
                i = i+2;
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 21,21};
        int result = sumFourDivisors(nums);
        System.out.println("===>" + result);
    }
}