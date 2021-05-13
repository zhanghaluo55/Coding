package com.hongpro.coding.atguigu.horse;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 回溯法 - 骑士周游问题
 * @date 2021/5/13 12:24
 */
public class HorseChessboard {
    private static int X;
    private static int Y;
    private static boolean visited[];
    private static boolean finish;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        travelChessboard(chessboard, 0, 0, 1);

        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 骑士周游问题算法
     * @param chessboard 棋盘
     * @param row 马儿当前位置行
     * @param column 列
     * @param step 第几步
     */
    public static void travelChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);

        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!visited[p.y * X + p.x]) {
                travelChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        if (step < X * Y && !finish) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finish = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        //5
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        //6
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }

        //7
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }

        //0
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }

        //1
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        //2
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }

        //3
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }

        //4
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }

        return ps;
    }

    public static void sort(ArrayList<Point> ps) {
        ps.sort((o1, o2) -> {
            int count1 = next(o1).size();
            int count2 = next(o2).size();
            return Integer.compare(count1, count2);
        });
    }
}
