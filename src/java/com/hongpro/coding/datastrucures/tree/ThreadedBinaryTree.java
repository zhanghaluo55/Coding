package com.hongpro.coding.datastrucures.tree;

/**
 * 线索化二叉树
 */
public class ThreadedBinaryTree {

}
class ThreadBinaryTree {
    public ThreadNode root;

    public ThreadNode pre = null;

    public void threadedList() {
        ThreadNode threadNode = root;
        while (threadNode != null) {
            while (threadNode.leftType == 0) {
                threadNode = threadNode.left;
            }

            System.out.println(threadNode);

            while (threadNode.rightType == 1) {
                threadNode = threadNode.right;
                System.out.println(threadNode);
            }

            threadNode = threadNode.right;
        }
    }

    /**
     * 中序线索化
     * @param node
     */
    public void threadNodes(ThreadNode node) {
        if (node == null) {
            return;
        }

        threadNodes(node.left);
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }

        if (pre != null && pre.right == null) {
            node.right = pre;
            node.rightType = 1;
        }

        pre = node;
        threadNodes(node.right);


    }

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

class ThreadNode {
    public int val;
    public ThreadNode left;
    public ThreadNode right;

    //leftType=0表示指向左子树，1表示指向前驱节点
    //rightType 0 表示右子数，1表示后继节点
    public int leftType;
    public int rightType;

    public ThreadNode(int val) {
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

    public ThreadNode preOrderSearch(int val) {
        if (this.val == val) {
            return this;
        }

        ThreadNode flag = null;
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
