package com.hongpro.coding.atguigu.dac;

/**
 * @author zhangzihong
 * @version 1.0.1.001
 * @description 分治法 - 汉诺塔问题
 * @date 2021/4/26 16:11
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第一个盘从" + a + "->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }

    }
}
