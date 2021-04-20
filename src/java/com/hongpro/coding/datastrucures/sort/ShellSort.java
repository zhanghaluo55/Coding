package com.hongpro.coding.datastrucures.sort;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/27 15:31
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        int temp = 0;
        int j = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                j = i;
                temp = arr[j];
                if (arr[j] > arr[j - gap]) {
                    while(temp < arr[j - gap] && j - gap >= 0) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
