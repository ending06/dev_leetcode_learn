package com.leetcode.code313;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-13<p>
// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List<Node> list = new ArrayList<>(nums.length);
        for(int i=0;i<nums.length;i++){
            list.add(new Node(nums[i],i));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value-o2.value;
            }
        });
        int i =0;
        int j = list.size()-1;
        while(i!=j){
            if(list.get(i).value+list.get(j).value==target){
                return new int[]{list.get(i).index,list.get(j).index};
            }else if(list.get(i).value+list.get(j).value<target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

    private static class Node {
        private int value;

        private int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("value=").append(value);
            sb.append(", index=").append(index);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int[] nums={2, 7, 11, 15};
        //int[] nums = { 3,2,4 };
        //int[] nums = { -1, -2, -3, -4, -5 };
        int[] result = twoSum(nums, 9);
        System.out.println("==>" + result);
    }
}