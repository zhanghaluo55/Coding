package com.hongpro.coding.datastrucures.search;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/4/2 12:22
 */
public class FibonacciSearch {
    public static void main(String[] args) {

    }

    public static int[] fib() {
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 20; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;
        int mid = 0;
        int[] f = fib();
        while (a.length  > f[k] - 1) {
            k++;
        }

        int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while(low <= high) {
            mid = low + f[k-1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]){
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }

        return -1;
    }
}
