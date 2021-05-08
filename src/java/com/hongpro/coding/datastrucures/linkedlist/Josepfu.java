package com.hongpro.coding.datastrucures.linkedlist;

/**
 * TODO 约瑟夫问题 环形链表
 *
 * @author zhangzihong
 * @data 2021/3/19 16:18
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLink circleSingleLink = new CircleSingleLink();
        circleSingleLink.addNode(5);
        circleSingleLink.list();
        circleSingleLink.circleBoy(1, 2 ,5);
    }

    public static void josepfuProblem(int num, int kill, int alive) {
        int[] nums = new int[num];
        int pos = -1;
        int i = 0;
        int count = 1;

        while(count <= num) {
            while(true) {
                pos = (pos + 1) % num;
                if (nums[pos] == 0) {
                    i++;
                }
                if (i == kill) {
                    i = 0;
                    break;
                }
            }
            nums[pos] = count;
            count++;
        }
        alive = count - alive;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] >= alive) {
                System.out.println(j+1);
            }
        }
    }
}

class CircleSingleLink {
    private LinkedNode first = new LinkedNode(-1);
    public void addNode(int num) {
        if (num < 1) {
            return;
        }

        LinkedNode cur = null; //辅助指针
        for (int i = 1; i <= num; i++) {
            LinkedNode linkedNode = new LinkedNode(i);
            if (i == 1) {
                first = linkedNode;
                first.next = first;
                cur = first;
            } else {
                cur.next = linkedNode;
                linkedNode.next = first;
                cur = linkedNode;
            }
        }
    }

    public void list() {
        if (first == null) {
            return;
        }

        LinkedNode linkedNode = first;
        while (true) {
            System.out.println(linkedNode.val);
            if (linkedNode.next == first) {
                break;
            }
            linkedNode = linkedNode.next;
        }
    }

    /**
     *
     * @param startVal 从哪个书开始
     * @param count 数几下
     * @param num 最初圈中的晓海
     */
    public void circleBoy(int startVal, int count, int num) {
        if (first == null || startVal < 1 || startVal > num) {
            return;
        }
        LinkedNode helper = first;
        while (helper.next != first) {
            helper = helper.next;
        }

        for (int i = 0; i < startVal - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while (helper != first) {
            for (int i = 0; i < count - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first.val);
            first = first.next;
            helper.next = first;
        }

        System.out.println("last child :" + first.val);
    }
}

class LinkedNode {
    public int val;
    public LinkedNode next; //指向下一节点

    public LinkedNode(int val) {
        this.val = val;
    }

    
}