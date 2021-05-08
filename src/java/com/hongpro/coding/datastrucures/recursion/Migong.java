package com.hongpro.coding.datastrucures.recursion;

/**
 * TODO 回溯 - 迷宫
 *
 * @author zhangzihong
 * @data 2021/3/25 12:20
 */
public class Migong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int j = 0; j < 6; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[1][2] = 1;
        map[2][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("-----------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路
     * 1. 从地图(1,1)出发，能到达(6,5)说明通路找到
     * 2. 0表示没走过 1表示墙 2 表示可走 3表示走过但走不通
     * 3. 迷宫策略 下->右->上->左, 走不通则回溯
     * @param map 地图
     * @param i 行
     * @param j 列
     * @return 找到返回true,否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map,i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)){
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if(setWay(map, i, j-1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
