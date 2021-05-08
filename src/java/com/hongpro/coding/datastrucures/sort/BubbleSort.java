package com.hongpro.coding.datastrucures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * TODO 冒泡排序
 *
 * @author zhangzihong
 * @data 2021/3/26 18:10
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(80000);
            arr[i] = i1;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println("排序前：" + format);

        bubbleSort(arr);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = sdf1.format(new Date());
        System.out.println("排序后：" + format1);

    }

    public static void  bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!flag) {
                break;
            }
        }
    }
}
