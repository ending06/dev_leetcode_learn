package com.leetcode.code0322;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// 考虑4双向问题
// -------------------------------------------------------

public class HasValidPah_2 {

    private static final String left = "left";

    private static final String right = "right";

    private static final String top = "top";

    private static final String botom = "botom";

    public static boolean hasValidPath(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        int n = grid[0].length;
        int m = grid.length;
        if (m == 1 & n == 1) {
            return true;
        }
        String need_dir = left;

        return funcation(0, 0, need_dir, m, n, grid);
    }

    /**
     *
     * */
    private static boolean funcation(int i, int j, String need_dir, int m, int n, int[][] grid) {
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1) {
            return false;
        }

        Road road = Road.getRoad(grid[i][j]);

        if (i == 0 && j == 0) {
            boolean result = false;

            if (road.left) {
                result =(result|| funcation(i, j - 1, HasValidPah_2.right, m, n, grid));
            }
            if (road.right) {
                result = (result|| funcation(i, j + 1, HasValidPah_2.left, m, n, grid));
            }

            if (road.top) {
                result = (result|| funcation(i - 1, j, HasValidPah_2.botom, m, n, grid));
            }
            if (road.botom) {
                result = (result|| funcation(i + 1, j, HasValidPah_2.top, m, n, grid));
            }
            return result;
        }

        if (road.isContain(need_dir)) {

            if ((i == m - 1) && (j == n - 1)) {
                return true;
            } else {
                String remian_dir = road.getRemain(need_dir);

                if (remian_dir == "") {
                    return false;
                }

                if (remian_dir.equalsIgnoreCase(HasValidPah_2.left)) {
                    return funcation(i, j - 1, HasValidPah_2.right, m, n, grid);
                }
                if (remian_dir.equalsIgnoreCase(HasValidPah_2.right)) {
                    return funcation(i, j + 1, HasValidPah_2.left, m, n, grid);
                }

                if (remian_dir.equalsIgnoreCase(HasValidPah_2.top)) {
                    return funcation(i - 1, j, HasValidPah_2.botom, m, n, grid);
                }
                if (remian_dir.equalsIgnoreCase(HasValidPah_2.botom)) {
                    return funcation(i + 1, j, HasValidPah_2.top, m, n, grid);
                }
                return false;
            }
        }
        return false;
    }

    private static class Road {
        private int value;

        private boolean left;

        private boolean right;

        private boolean top;

        private boolean botom;

        public Road(int value, boolean left, boolean right, boolean top, boolean botom) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.top = top;
            this.botom = botom;
        }

        public static Road getRoad1() {
            return new Road(1, true, true, false, false);
        }

        public static Road getRoad2() {
            return new Road(2, false, false, true, true);
        }

        public static Road getRoad3() {
            return new Road(3, true, false, false, true);
        }

        public static Road getRoad4() {
            return new Road(4, false, true, false, true);
        }

        public static Road getRoad5() {
            return new Road(5, true, false, true, false);
        }

        public static Road getRoad6() {
            return new Road(6, false, true, true, false);
        }

        public boolean isContain(String name) {
            if (name == HasValidPah_2.left) {
                return this.left;
            }
            if (name == HasValidPah_2.right) {
                return this.right;
            }
            if (name == HasValidPah_2.top) {
                return this.top;
            }
            if (name == HasValidPah_2.botom) {
                return this.botom;
            }
            return false;
        }

        public String getRemain(String need_dir) {
            if (this.left && !HasValidPah_2.left.equalsIgnoreCase(need_dir)) {
                return HasValidPah_2.left;
            }
            if (this.right && !HasValidPah_2.right.equalsIgnoreCase(need_dir)) {
                return HasValidPah_2.right;
            }
            if (this.top && !HasValidPah_2.top.equalsIgnoreCase(need_dir)) {
                return HasValidPah_2.top;
            }
            if (this.botom && !HasValidPah_2.botom.equalsIgnoreCase(need_dir)) {
                return HasValidPah_2.botom;
            }
            return "";
        }

        public static Road getRoad(int input) {
            if (input == 1) {
                return getRoad1();
            }

            if (input == 2) {
                return getRoad2();
            }

            if (input == 3) {
                return getRoad3();
            }

            if (input == 4) {
                return getRoad4();
            }

            if (input == 5) {
                return getRoad5();
            }

            if (input == 6) {
                return getRoad6();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 2, 4, 3 }, { 6, 5, 2 } };
        boolean result = hasValidPath(grid);
        System.out.println("1===>" + result);

        int[][] grid2 = new int[][] { { 1, 2, 1 }, { 1, 2, 1 } };
        boolean result2 = hasValidPath(grid2);
        System.out.println("2===>" + result2);

        int[][] grid3 = new int[][] { { 1, 1, 2 } };
        boolean result3 = hasValidPath(grid3);
        System.out.println("3===>" + result3);

        int[][] grid4 = new int[][] { { 1, 1, 1, 1, 1, 1, 3 } };
        boolean result4 = hasValidPath(grid4);
        System.out.println("4===>" + result4);

        int[][] grid5 = new int[][] { { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 2 }, { 6 } };
        boolean result5 = hasValidPath(grid5);
        System.out.println("5===>" + result5);

        int[][] grid6 = new int[][] { { 4, 1 }, { 6, 1 } };
        boolean result6 = hasValidPath(grid6);
        System.out.println("5===>" + result6);

    }
}