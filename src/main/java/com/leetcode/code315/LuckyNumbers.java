package com.leetcode.code315;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-15<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {

    public static List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;

        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("===>"+i+";===>j"+j+";====>m"+m+";===>n"+n);
                boolean smallRow = smallRow(matrix, i, n, matrix[i][j]);
                boolean maxLie = maxLie(matrix, j, m, matrix[i][j]);
                if (smallRow && maxLie) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

    private static boolean smallRow(int[][] matrix, int i, int n, int tartget) {
        for (int k = 0; k < n; k++) {
            if (matrix[i][k] < tartget) {
                return false;
            }
        }
        return true;
    }

    private static boolean maxLie(int[][] matrix, int j, int m, int target) {
        for (int k = 0; k < m; k++) {
            if (matrix[k][j] > target) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] matirc = new int[][] { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } };
        //int[][] matirc = new int[][] {{7,8},{1,2}};
        int[][] matirc = new int[][] {{3,7,8},{9,11,13},{15,16,17}};
        List<Integer> result = luckyNumbers(matirc);
        System.out.println("===>" + result);
    }

}