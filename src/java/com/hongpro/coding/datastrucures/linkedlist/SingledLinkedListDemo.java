package com.hongpro.coding.datastrucures.linkedlist;

import java.util.Stack;

/**
 * TODO 单向链表
 *
 * @author zhangzihong
 * @data 2021/3/19 11:22
 */
public class SingledLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "松江");
        HeroNode heroNode3 = new HeroNode(3, "傻逼2");
        HeroNode heroNode2 = new HeroNode(2, "傻逼");
        HeroNode heroNode4 = new HeroNode(4, "傻逼3");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        singleLinkedList.list();


    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }

    public static HeroNode getLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        if (index <= 0 || index > length) {
            return null;
        }

        HeroNode cur = head.next;
        for (int i = 0; i < getLength(head) - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseList = new HeroNode(0, " ");
        HeroNode cur = head.next;
        HeroNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = reverseList.next;
            reverseList.next = cur;
            cur = next;
        }
        head.next = reverseList.next;
    }

    public static void reversetPrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static HeroNode mergeTwoLinkedList(HeroNode head1, HeroNode head2) {
        HeroNode head = new HeroNode(0, "");
        HeroNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.next.no > head2.next.no) {
                cur.next = head2.next;
                head2 = head2.next;
            } else {
                cur.next = head1.next;
                head1 = head1.next;
            }
            cur = cur.next;
        }
        cur.next = (head1 == null) ? head2 : head1;
        return head;
    }

}
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                return;
            } else if (temp.next.no > heroNode.no) {
                break;
            } else if(temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("node is exist");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void list() {
        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        while(true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = head;
        if (temp.next == null) {
            return;
        }

        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.no = heroNode.no;
        } else {
            System.out.println("no found");
        }
    }

    public void remove(int id) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == id) {
                flag = true;
                break;
            }

            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.println("node is not exist");
            }
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' + "}";
    }
}
