package com.hongpro.coding.atguigu.prim;

import java.util.Arrays;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 贪心算法 - 普利姆算法
 * @date 2021/5/10 12:49
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };

        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, data, weight);
        minTree.showGraph(mGraph);

        minTree.prim(mGraph, 1);
    }

}

//创建最小生成树
class MinTree {
    /**
     * @param mGraph 图对象
     * @param verxs 图对应顶点个数
     * @param data 图顶点值
     * @param weight 图的边
     */
    public void createGraph(MGraph mGraph, int verxs, char[] data, int[][] weight) {
        int i,j;
        for (i = 0; i < verxs; i++) {
            mGraph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prim算法，得到最小生成树
     * @param graph 图
     * @param v bi表示从第几个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.verxs];
        visited[v] = 1;
        //顶点下标 h1,h2
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < graph.verxs; k++) {

            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }

    }

}

class MGraph {
    int verxs; //节点个数
    char[] data; //节点数据
    int[][] weight; //存放边

    public MGraph(int verxs) {
        this.verxs = verxs;
        this.data = new char[verxs];
        this.weight = new int[verxs][verxs];
    }


}
