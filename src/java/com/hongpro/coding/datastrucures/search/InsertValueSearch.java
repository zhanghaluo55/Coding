package com.hongpro.coding.datastrucures.search;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/31 18:01
 */
public class InsertValueSearch {
    public static void main(String[] args) {

    }

    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || arr[0] > findVal || arr[arr.length - 1] < findVal) {
            return -1;
        }

        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
