package com.hongpro.coding.datastrucures.search;

/**
 * TODO 二分查找法
 *
 * @author zhangzihong
 * @data 2021/3/30 18:56
 */
public class BinarySearch {
    public static void main(String[] args) {
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }

        if (findVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
