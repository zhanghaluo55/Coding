package com.hongpro.coding.atguigu.dynamic;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 动态规划法 - 01背包问题
 * @date 2021/5/7 12:01
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3}; //物品重量
        int[] val = {1500, 3000, 2000}; //物品价值
        int m = 4; //背包容量
        int n = val.length; //物品个数

        //创建二维数组
        //v[i][j]表示前i个物品中能够装入容量为j的背包的最大价值
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }


        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        int i = path.length - 1;
        int j = path[0].length - 1;

        while (i > 0 && j > 0) {
            if (path[i][j] > 0) {
                System.out.printf("第%d个商品放入到背包\n" + i);
                j -= w[i - 1];
            }
            i -= 1;
        }
    }



}

