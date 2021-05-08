package com.hongpro.coding.datastrucures.hastable;

import java.util.Scanner;

/**
 * 哈西表法
 */
public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable(7);
        Scanner scanner = new Scanner(System.in);
    }


}

class Hashtable {
    private EmpLinkedList[] empLinkedListArray;

    private int size;

    public Hashtable(int size) {
        empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int index = hashFun(emp.id);
        empLinkedListArray[index].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

    public void findEmpById(int id) {
        int index = hashFun(id);
        Emp emp = empLinkedListArray[index].findEmpById(id);
        if (emp != null) {
            System.out.println("find");
        } else {
            System.out.println("notFind");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        cur.next = emp;
    }

    public void list() {
        if (head == null) {
            return;
        }

        Emp cur = head;
        while (true) {
            System.out.printf("-> id = %d, name = ", cur.id, cur.name);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            return null;
        }

        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                break;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }

        return cur;
    }
}