package com.leetcode.code0322;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// -------------------------------------------------------

public class HasValidPath {

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
        String need_dir = getNeedDir(grid[0][0], m, n);
        if (need_dir == "") {
            return false;
        }

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

        if (road.isContain(need_dir)) {

            if ((i == m - 1) && (j == n - 1)) {
                return true;
            } else {
                String remian_dir = road.getRemain(need_dir);

                if (remian_dir == "") {
                    return false;
                }

                if (remian_dir.equalsIgnoreCase(HasValidPath.left)) {
                    return funcation(i, j - 1, HasValidPath.right, m, n, grid);
                }
                if (remian_dir.equalsIgnoreCase(HasValidPath.right)) {
                    return funcation(i, j + 1, HasValidPath.left, m, n, grid);
                }

                if (remian_dir.equalsIgnoreCase(HasValidPath.top)) {
                    return funcation(i - 1, j, HasValidPath.botom, m, n, grid);
                }
                if (remian_dir.equalsIgnoreCase(HasValidPath.botom)) {
                    return funcation(i + 1, j, HasValidPath.top, m, n, grid);
                }
                return false;
            }
        }
        return false;
    }

    private static String getNeedDir(int road, int m, int n) {
        Road roadNumber = Road.getRoad(road);

        // 一行
        if (m == 1 && n != 1) {
            return getOnelineNeeDir(roadNumber);
        }

        // 一列
        if (m != 1 && n == 1) {
            return getOneColumsNeedDir(roadNumber);
        }

        // 多维数组
        return getMultiNeedDir(roadNumber);

    }

    private static String getMultiNeedDir(Road roadNumber) {
        if (roadNumber.value == 1) {
            return HasValidPath.left;
        }
        if (roadNumber.value == 2) {
            return HasValidPath.top;
        }
        if (roadNumber.value == 3) {
            return HasValidPath.left;
        }
        if (roadNumber.value == 4 || roadNumber.value == 5) {
            return "";
        }
        if (roadNumber.value == 6) {
            return HasValidPath.top;
        }
        return "";
    }

    private static String getOnelineNeeDir(Road roadNumber) {
        if (roadNumber.value == 1) {
            return HasValidPath.left;
        }

        if (roadNumber.value == 2 || roadNumber.value == 3 || roadNumber.value == 5) {
            return "";
        }

        if (roadNumber.value == 4) {
            return HasValidPath.botom;
        }

        if (roadNumber.value == 6) {
            return HasValidPath.top;
        }
        return "";
    }

    private static String getOneColumsNeedDir(Road roadNumber) {
        if (roadNumber.value == 1 || roadNumber.value == 5 || roadNumber.value == 6) {
            return "";
        }

        if (roadNumber.value == 2) {
            return HasValidPath.top;
        }
        if (roadNumber.value == 3) {
            return HasValidPath.left;
        }

        if (roadNumber.value == 4) {
            return HasValidPath.right;
        }
        return "";
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
            if (name == HasValidPath.left) {
                return this.left;
            }
            if (name == HasValidPath.right) {
                return this.right;
            }
            if (name == HasValidPath.top) {
                return this.top;
            }
            if (name == HasValidPath.botom) {
                return this.botom;
            }
            return false;
        }

        public String getRemain(String need_dir) {
            if (this.left && !HasValidPath.left.equalsIgnoreCase(need_dir)) {
                return HasValidPath.left;
            }
            if (this.right && !HasValidPath.right.equalsIgnoreCase(need_dir)) {
                return HasValidPath.right;
            }
            if (this.top && !HasValidPath.top.equalsIgnoreCase(need_dir)) {
                return HasValidPath.top;
            }
            if (this.botom && !HasValidPath.botom.equalsIgnoreCase(need_dir)) {
                return HasValidPath.botom;
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

        int[][] grid3 = new int[][] { { 1,1,2 } };
        boolean result3 = hasValidPath(grid3);
        System.out.println("3===>" + result3);

        int[][] grid4 = new int[][] { { 1,1,1,1,1,1,3} };
        boolean result4 = hasValidPath(grid4);
        System.out.println("4===>" + result4);

        int[][] grid5 = new int[][] {{2},{2},{2},{2},{2},{2},{6} };
        boolean result5 = hasValidPath(grid5);
        System.out.println("5===>" + result5);


        int[][] grid6 = new int[][] {{4,1},{6,1} };
        boolean result6 = hasValidPath(grid6);
        System.out.println("5===>" + result6);

    }
}