package com.leetcode.code315;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-15<p>
// -------------------------------------------------------

public class CustomStack {

    int[] array = null;
    int size = 0;
    int count = 0;

    public CustomStack(int maxSize) {
        array = new int[maxSize];
        size = maxSize;
        count = 0;
    }

    public void push(int x) {
        if (count!= size) {
            array[count] = x;
            count++;
        }
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        count--;
        int result = array[count];
        return result;
    }

    public void increment(int k, int val) {
        if (array!=null) {
            int end = array.length>=k?k:array.length;
            for (int i = 0; i < end; i++) {
                array[i] = array[i] + val;
            }
        }
    }
    //["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
    //[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]

    //[null,null,null,2,null,null,null,null,null,103,202,201,-1]
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        int result = customStack.pop(); //2
        System.out.println("===>"+result);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);//失败
        customStack.increment(5,100);//  101 102 103
        customStack.increment(2,100);  //201 202

        int result1 = customStack.pop();
        int result2 =customStack.pop();
        int result3 =customStack.pop();
        int result4 =customStack.pop();
        System.out.println("===>");
    }
}