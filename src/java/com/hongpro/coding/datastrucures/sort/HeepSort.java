package com.hongpro.coding.datastrucures.sort;

public class HeepSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heepSort(arr);
    }

    public static void heepSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeep(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeep(arr, 0, j);
        }
    }

    /**
     * 完成以i对应的非叶子节点的树调整成大顶堆
     * @param arr 数组
     * @param i 非叶子节点在数组中的索引
     * @param length 表示有多少个元素进行调整
     */
    public static void adjustHeep(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = 2 * i + 1; k < length; k = k * 2  + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
