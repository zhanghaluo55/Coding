package com.hongpro.coding.datastrucures.queue;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/19 10:12
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class CircleArray {
    private int maxSize;

    private int front;

    private int rear;

    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = 0; //指向队列头部，队列头前一个位置
        rear = 0;  //指向队列尾， 指向队列尾部的数据
    }

    public boolean isFull() {
       return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }


    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
