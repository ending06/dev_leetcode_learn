package com.leetcode.code39;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-09<p>
// 1366. 通过投票对团队排名
// -------------------------------------------------------

import java.util.TreeSet;

public class RankTeams {

    public static String rankTeams(String[] votes) {
        int num = votes[0].length();
        // 打表，横26个字母，竖排名。
        int[][] res = new int[num][26];
        for (int i = 0; i < num; i++) {
            for (String v : votes) {
                int idx = v.charAt(i) - 'A';
                res[i][idx] += 1;
            }
        }
        // 用一个set存还没排名的下标(字母)
        TreeSet<Integer> idxs = new TreeSet<>();
        for (int i = 0; i < votes[0].length(); i++)
            idxs.add(votes[0].charAt(i) - 'A');

        // 每次都找第一，然后删除该字母的排名，删除set中的下标，循环
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int idx = findMost(res, 0, idxs);
            for (int j = 0; j < num; j++)
                res[j][idx] = 0;
            idxs.remove(idx);
            sb.append((char) (idx + 'A'));
        }
        return sb.toString();
    }

    // 层层深入的递归，找当前排第一的字母。
    private static int findMost(int[][] nums, int level, TreeSet<Integer> idxs) {
        if (idxs.size() == 1 || level == nums.length)
            return idxs.first();
        int maxi = idxs.first();
        for (int i : idxs) {
            if (nums[level][i] > nums[level][maxi])
                maxi = i;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i : idxs) {
            if (nums[level][i] == nums[level][maxi])
                set.add(i);
        }
        return findMost(nums, level + 1, set);
    }

    public static void main(String[] args) {
        //String[] votes = { "WXYZ", "XYZW" };
        //String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        String[] votes = { "BCA", "CAB", "CBA", "ABC", "ACB", "BAC" };
        String result = rankTeams(votes);
        System.out.println("===>" + result);
    }
}