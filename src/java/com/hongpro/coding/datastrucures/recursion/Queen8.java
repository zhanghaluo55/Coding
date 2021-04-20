package com.hongpro.coding.datastrucures.recursion;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/25 18:54
 */
public class Queen8 {
    int max = 8;
    static int count = 0;

    int[] array = new int[max];

    public void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        count++;
        //"一共有:" + count
        System.out.println();
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }
}
