package com.hongpro.coding.datastrucures.tree;

/**
 * @Author ZhangZihong
 * @Description
 * @Date 12:45 2021/4/14
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
    }

}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr ==  null || arr.length == 0) {
            return;
        }

        System.out.println(arr[index]);

        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        if (index * 2 + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
