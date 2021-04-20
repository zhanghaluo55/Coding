package com.hongpro.coding.datastrucures.linkedlist;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/19 15:33
 */
public class DoubleLinkedListDemo {

}

class DoubleLinkedList {
    private ListNode head = new ListNode(-1);

    public ListNode getHead() {
        return head;
    }

    public void add(ListNode listNode) {
        ListNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = listNode;
        listNode.pre = temp;
    }

    public void addByOrder(ListNode listNode) {
        ListNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                return;
            } else if (temp.val > listNode.val) {
                break;
            } else if(temp.val == listNode.val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("node is exist");
        } else {
            listNode.pre = temp.pre;
            listNode.next = temp;
            temp.pre = listNode;
        }
    }

    public void list() {
        if (head.next == null) {
            return;
        }

        ListNode temp = head.next;
        while(true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(ListNode listNode) {
        ListNode temp = head;
        if (temp.next == null) {
            return;
        }

        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.val == listNode.val) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.val = listNode.val;
        } else {
            System.out.println("no found");
        }
    }

    public void remove(int id) {
        ListNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.val == id) {
                flag = true;
                break;
            }

            if (flag) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }

            } else {
                System.out.println("node is not exist");
            }
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode pre;
    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

