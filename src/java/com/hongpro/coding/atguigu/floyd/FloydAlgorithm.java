package com.hongpro.coding.atguigu.floyd;

import java.util.Arrays;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 弗洛伊德算法-求各个点的最短路径
 * @date 2021/5/12 17:21
 */
public class FloydAlgorithm {
    public static void main(String[] args) {

    }
}

class Graph {
    private char[] vertex; //存放顶点的数组
    private int[][] dis; //从各个顶点到其他顶点的距离，结果也保留在该数组
    private int[][] pre; //保存到达目标顶点的前驱节点

    /**
     *
     * @param length 大小
     * @param matrix 邻接矩阵
     * @param vertex 顶点数组
     */
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }



    }

    public void show() {
        char[] vertex = new char[]{'A','B','C','D','E','F','G'};
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[k] + "->" + vertex[i] + ":" + dis[k][i] + " ");
            }
            System.out.println();
        }
    }

    public void floyd() {
        int len = 0; //变量保留的距离
        //k中间顶点, k就是中间顶点的下标[A,B,C,D,E,F,G]
        for (int k = 0; k < dis.length; k++) {
            //i顶点出发
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];  //从i顶点出发，经过k到达中间顶点,到达j顶点
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}