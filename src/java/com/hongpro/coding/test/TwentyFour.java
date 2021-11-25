package com.hongpro.coding.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description:
 * @Author: zhangzihong
 * @CreateTime: 2021/9/10
 * @Version:
 */
public class TwentyFour {
    static Set<Double[]> allSort = new HashSet<>();//存储全排列组合

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double[] d = new double[4];
            d[0] = sc.nextInt();
            d[1] = sc.nextInt();
            d[2] = sc.nextInt();
            d[3] = sc.nextInt();
            allSort(d, 0);//计算全排列

            boolean flag = false;//判断是否有ture
            for (Double[] doubles : allSort) {//遍历set
                if (solve(doubles, doubles[0], 0)) {//
                    flag = true;//出现了成功的情况，跳出循环
                    System.out.println(true);
                    break;
                }
            }
            if(!flag){//没有成功的情况
                System.out.println(false);
            }
            allSort.clear();//set清空
        }
    }

    //计算每一种排列是否可以24点  dfs递归 flag:表示计算到的下标
    //result 初始化为 double数组的第一位 flag初始化为0
    private static boolean solve(Double[] d, double result, int flag) {
        if (flag == 3 && result == 24) {//满足条件的递归出口
            return true; //计算到了最后一位且 结果恰巧为24
        }
        if(flag == 3 && result != 24){//不满足条件的递归出口
            return  false;
        }
        flag++;
        return solve(d, result + d[flag], flag) ||
                solve(d, result - d[flag], flag) ||
                solve(d, result * d[flag], flag) ||
                solve(d, result / d[flag], flag);
    }

    //全排列 详情见剑指offer 38 题
    private static void allSort(double[] d, int index) {
        if (index == d.length - 1) {
            allSort.add(new Double[]{d[0], d[1], d[2], d[3]});
            return;
        }

        for (int i = index; i <= d.length - 1; i++) {
            swap(d, index, i);
            allSort(d, index + 1);
            swap(d, index, i);
        }

    }

    //交换
    private static void swap(double[] a, int i, int j) {
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
