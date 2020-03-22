package com.leetcode.code321;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 2020-03-22<p>
// -------------------------------------------------------

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.min;

public class CanMeasureWater {

    public static boolean canMeasureWater(int x, int y, int z) {

        List<CombInfo> history = new ArrayList<>();

        return funcation(0, 0, x, y, z, history);
    }

    private static boolean funcation(int remain_x, int remian_y, int x, int y, int target, List<CombInfo> history) {

        System.out.println("===>"+history);

        CombInfo combInfo = new CombInfo(remain_x,remian_y) ;

        if(history.contains(combInfo)){
            return false;
        }else {
            history.add(combInfo);
        }

        if(remain_x==target||remian_y==target||(remain_x+remian_y==target)){
            return true;
        }

        //X装满
        funcation(x,remian_y,x,y,target,history);

        //y装满
        funcation(remain_x,y,x,y,target,history);

        //x清空
        funcation(0,remian_y,x,y,target,history);

        //y清空
        funcation(remain_x,0,x,y,target,history);

        //x倒入y
        funcation(remain_x-min(remain_x,y-remian_y),remian_y+min(remain_x,y-remian_y),x,y,target,history);

        //y倒入x
        funcation(remain_x+min(remian_y,x-remain_x),y-min(remian_y,x-remain_x),x,y,target,history);

        return false;
    }

    private static class CombInfo {
        private int x;
        private int y;

        public CombInfo(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof CombInfo))
                return false;
            CombInfo combInfo = (CombInfo) o;
            return x == combInfo.x && y == combInfo.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("CombInfo{");
            sb.append("x=").append(x);
            sb.append(", y=").append(y);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println("===>" + canMeasureWater(3, 5, 4));
        System.out.println("====>" + canMeasureWater(2, 6, 5));
    }
}