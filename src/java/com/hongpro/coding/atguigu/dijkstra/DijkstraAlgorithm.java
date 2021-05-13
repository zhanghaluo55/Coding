package com.hongpro.coding.atguigu.dijkstra;

import java.util.Arrays;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 迪杰斯特拉算法 - 求最短路径
 * @date 2021/5/11 17:05
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertex = new char[]{'A','B','C','D','E','F','G'};
        final int INF = 65535;
        int[][] weight = new int[][]{
                {INF, 5, 7, INF, INF, INF, 2},
                {5, INF, INF, 9, INF, INF, 3},
                {7, INF, INF, INF, 8, INF, INF},
                {INF, 9, INF, INF, INF, 4, INF},
                {INF, INF, 8, INF, INF, 5, 4},
                {INF, INF, INF, 4, 5, INF, 6},
                {2, 3, INF, INF, 4, 6, INF}
        };

        Graph graph = new Graph(vertex, weight);
        graph.dsj(6);
        graph.showGraph();
        graph.showDjs();

    }
}

class VisitedVertex {
    //顶点是否访问过，1访问，0未访问
    public int[] already_arr;
    //每个下标对应的前一顶点下标
    public int[] pre_visited;
    //出发顶点到其他所有顶点的距离
    public int[] dis;

    /**
     * @param length 顶点个数
     * @param index  出发顶点下标
     */
    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 65535);
        already_arr[index] = 1;
        this.dis[index] = 0;
    }

    /**
     * 判断index下标的顶点是否访问过
     *
     * @param index
     * @return
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发顶点到index顶点
     *
     * @param index
     * @param len
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新顶点的前驱为 index 的节点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 返回出发顶点到index的距离
     *
     * @param index
     * @return
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 继续选择并返回新的访问节点
     *
     * @return
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }

    public void show() {
        System.out.println("=================");
        for (int i : already_arr) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : pre_visited) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : dis) {
            System.out.print(i + " ");
        }

        System.out.println();
        char[] vertex = new char[]{'A','B','C','D','E','F','G'};
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "(" + i + ")");
            } else {
                System.out.print("N");
            }
            count++;
        }
        System.out.println();
    }
}

class Graph {
    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 迪杰斯特拉算法实现
     * @param index 出发顶点下标
     */
    public void dsj(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);

        for (int i = 0; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }

    }

    public void showDjs() {
        vv.show();
    }

    /**
     * 更新index下标的顶点到周围顶点的距离和周围顶点的前驱顶点
     * @param index
     */
    public void update(int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            //出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][i];

            //如果i顶点还没被访问到，并且len小于出发顶点到i顶点的距离，就需要更新
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updatePre(i, index);
                vv.updateDis(i, len);
            }
            
        }

    }
}