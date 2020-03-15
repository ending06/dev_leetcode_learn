package com.leetcode.code315;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-15<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */

public class BalanceBST {
    public static TreeNode balanceBST(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        readTree(result, root);

        if (result.size() <= 2) {
            return root;
        }

        TreeNode head = new TreeNode();
        createTree(result, head);

        return head;
    }

    private static void createTree(List<Integer> result, TreeNode head) {

        if (result == null || result.size() == 0) {
            return;
        }
        if (result.size() == 1) {
            head.val = result.get(0);
            return;
        }

        int middle = result.size() / 2;

        head.val = result.get(middle);
        head.left = new TreeNode();

        createTree(subList(result, 0, middle), head.left);

        if (middle != result.size() - 1) {
            head.right = new TreeNode();
            createTree(subList(result, middle + 1, result.size()), head.right);
        }
    }

    private static List<Integer> subList(List<Integer> result, int start, int end) {
        List<Integer> newList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            newList.add(result.get(i));
        }
        return newList;
    }

    private static void readTree(List<Integer> result, TreeNode root) {
        if (root.left != null) {
            readTree(result, root.left);
        }

        result.add(root.val);

        if (root.right != null) {
            readTree(result, root.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }

    public static void main(String[] args) {
        TreeNode root4 = new TreeNode(4);
        TreeNode root3 = new TreeNode(3);
        root3.right = root4;

        TreeNode root2 = new TreeNode(2);
        root2.right = root3;

        TreeNode root = new TreeNode(1);
        root.right = root2;

        TreeNode result = balanceBST(root);
        System.out.println("====>" + result);
    }
}