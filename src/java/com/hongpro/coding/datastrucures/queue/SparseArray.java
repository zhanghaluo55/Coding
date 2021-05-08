package com.hongpro.coding.datastrucures.queue;

/**
 * TODO 稀疏数组
 *
 * @author zhangzihong
 * @data 2021/3/18 18:59
 */
public class SparseArray {
    public static void main(String[] args) {
        //二维数组11*11
        int charArr[][] = new int[11][11];
        charArr[1][2] = 1;
        charArr[2][3] = 2;
        int sum = 0;
        for (int[] row : charArr) {
            for (int data : row) {
                System.out.print(data + " ");
                if (data != 0) {
                    sum++;
                }
            }
            System.out.println();
        }

        System.out.println("sum : " + sum);
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //二维转稀疏数组
        int count = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (charArr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = charArr[i][j];
                    count++;
                }
            }
        }

        //稀疏转二维
        int[][] charArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            charArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
    }
}
