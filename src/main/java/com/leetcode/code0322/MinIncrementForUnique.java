package com.leetcode.code0322;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// 945 使数组唯一的最小增量
//-------------------------------------------------------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinIncrementForUnique {

    private static int optCount = 0;

    public static int minIncrementForUnique(int[] A) {
        if(A.length==1){
            return 0;
        }
        optCount = 0;

        Arrays.sort(A);

        List<Integer> source = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            source.add(A[i]);
        }

        function(source);

        return optCount;
    }

    private static void function(List<Integer> array) {

        int i = 0;

        int start = array.get(i);
        if(array.size()==1){
            return;
        }
        for(int k=i+1;k<array.size();k++){
            if(array.get(k)==start){
                optCount= optCount+1;
                array.set(k,array.get(k)+1);
            }
        }
        function(array.subList(i+1,array.size()));
    }


    public static void main(String[] args) {
/*        int[] a = new int[]{1,2,2};

        int result = minIncrementForUnique(a);

        System.out.println("===>"+result);*/

        int[] b = new int[]{3,2,1,2,1,7};

        int result1 = minIncrementForUnique(b);

        System.out.println("===>"+result1);
    }
}