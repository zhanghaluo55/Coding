package com.hongpro.coding.datastrucures.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

    }
}

class BinaryTree {
    public Node root;

    public void preOrder() {
        if (this.root != null) {
            root.preOrder();
        }
    }


    public void delNode(int val) {
        if (root.val == val) {
            root = null;
        } else {
            root.delNode(val);
        }
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public void delNode(int val) {
        if (this.left != null && this.left.val == val) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.val == val) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(val);
        }

        if (this.right != null) {
            this.right.delNode(val);
        }

    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    public Node preOrderSearch(int val) {
        if (this.val == val) {
            return this;
        }

        Node flag = null;
        if (this.left != null) {
            flag = this.left.preOrderSearch(val);
        }

        if (flag != null) {
            return flag;
        }

        if (this.right != null) {
            flag = this.right.preOrderSearch(val);
        }
        return flag;
    }
}