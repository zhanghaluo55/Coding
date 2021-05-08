package com.hongpro.coding.datastrucures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhangzihong
 * @version 1.0.0 图
 * @date 2021/4/20 12:12
 */
public class Graph {
    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储对应的邻接矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;
    //记录某个节点是否被访问
    private boolean[] isVisited = new boolean[5];

    public static void main(String[] args) {

    }

    public void bfs(boolean[] isVisited, int i) {
        int u; //头结点对应下标
        int w; //邻接节点
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);

        while(!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);

            while (w != -1) {
                if (isVisited[w]) {
                    System.out.println(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }

    }

    /**
     * 深度优先遍历
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited, int i) {
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while(w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }

            w = getNextNeighbor(i, w);
        }
    }

    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    /**
     * 得到第一个邻接节点的下标
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点下标得到下一个邻接节点的下标
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }



    public Graph(int n) {
        this.numOfEdges = 0;
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraphs() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }




}
