package com.hongpro.coding.datastrucures.sort;

import java.util.Arrays;

/**
 * TODO 快排
 *
 * @author zhangzihong
 * @data 2021/3/27 16:58
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-58, 100, 50, 30, -100, 90, 300};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];

        while(l < r) {
            while(arr[l] < pivot) {
                l += 1;
            }

            while (arr[r] > pivot) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot) {
                r -= 1;
            }

            if (arr[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr, left, r);
        }

        if (l < right) {
            quickSort(arr, l, right);
        }

    }
}
