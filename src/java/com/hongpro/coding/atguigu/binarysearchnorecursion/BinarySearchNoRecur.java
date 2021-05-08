package com.hongpro.coding.atguigu.binarysearchnorecursion;

/**
 * @author zhangzihong
 * @version 1.0.1.001
 * @description 二分查找
 * @date 2021/4/26 15:36
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = left + 1;
            }
        }
        return -1;
    }
}
