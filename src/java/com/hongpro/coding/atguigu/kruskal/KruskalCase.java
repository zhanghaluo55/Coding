package com.hongpro.coding.atguigu.kruskal;

import java.util.Arrays;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 克鲁斯卡尔算法 - 最小生成树
 * @date 2021/5/10 16:08
 */
public class KruskalCase {
    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] verxs = new char[]{'A','B','C','D','E','F','G'};
        int[][] weight = new int[][]{
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };

        KruskalCase kruskalCase = new KruskalCase(verxs, weight);
        kruskalCase.print();
        EData[] edges = kruskalCase.getEdges();
        System.out.println("排序前：" + Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println("排序后：" + Arrays.toString(edges));
        kruskalCase.kruskal();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        int len = vertexs.length;

        this.vertexs = new char[len];
        for (int i = 0; i < vertexs.length; i++) {
            this.vertexs[i] = vertexs[i];
        }

        this.matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (this.matrix[i][j] != INF && this.matrix[i][j] != 0) {
                    edgeNum++;
                }
            }
            
        }
    }

    //打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%20d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 返回定点下标
     * @param ch 定点值
     * @return 对应下标
     */
    public int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放到EData[]数组中，供后面遍历数组用
     * 通过matrix邻接矩阵获取
     * EData[]形式[['A','B',12],['B','F',7]]
     * @return
     */
    public EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
               if (matrix[i][j] != INF) {
                   EData eData = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                   edges[index++] = eData;
                   System.out.println(eData.toString());
               }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，用于后面判断两顶点终点是否相同
     * @param ends 记录各个顶点对应的终点是哪个，在遍历过程中逐步形成
     * @param i 传入顶点的下标
     * @return 下标为i的顶点对应的终点下标
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        int index = 0; //表示最后结果的数组索引
        int[] ends = new int[edgeNum]; //用于保存”已有最小生成树“中的每个顶点在最小生成树中的终点
        //创建结果数组
        EData[] rets = new EData[edgeNum];

        EData[] edges = getEdges();
        //获取图中所有边的集合，共12边
        System.out.println("图的边的集合：" + Arrays.toString(edges) + "共" + edges.length);
        sortEdges(edges);

        for (int i = 0; i < edges.length; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            //p1最小生成树中的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        System.out.println("最小生成树为:" + Arrays.toString(rets));
    }
}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

