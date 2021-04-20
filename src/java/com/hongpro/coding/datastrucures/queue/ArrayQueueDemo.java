package com.hongpro.coding.datastrucures.queue;

import java.util.Scanner;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/18 19:44
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a' :
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
            }
        }
    }

}
class ArrayQueue {
    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1; //指向队列头部，队列头前一个位置
        rear = -1;  //指向队列尾， 指向队列尾部的数据
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            return;
        }
        arr[++rear] = n;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        return arr[++front];
    }

    public void showQueue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }

    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

}
