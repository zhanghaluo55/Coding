package com.hongpro.coding.datastrucures.tree;

public class AVLTreeDemo {

}

class AVLTree {
    private AVLTreeNode root;
    public void add(AVLTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 返回以node为根节点的二叉排序树的最小节点值
     * 删除之
     * @param node
     * @return
     */
    public int delRightTreeMin(AVLTreeNode node) {
        AVLTreeNode targetNode = node;
        while(targetNode.left != null) {
            targetNode = targetNode.left;
        }
        delNode(targetNode.val);
        return targetNode.val;
    }

    public AVLTreeNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public AVLTreeNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            AVLTreeNode targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            AVLTreeNode parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.val == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.val == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                targetNode.val = delRightTreeMin(targetNode.right);
            } else {
                if (targetNode.left != null) {
                    if (parent != null) {
                        if (parent.left.val == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.val == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }
        }
    }

}



class AVLTreeNode {
    int val;
    AVLTreeNode left;
    AVLTreeNode right;

    public AVLTreeNode(int val) {
        this.val = val;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public void leftRote() {
        AVLTreeNode newNode = new AVLTreeNode(val);
        newNode.left = left;
        newNode.right = right.left;
        val = right.val;
        right = right.right;
        left = newNode;
    }

    public void rightRote() {
        AVLTreeNode newNode = new AVLTreeNode(val);
        newNode.right = right;
        newNode.left = left.right;
        val = left.val;
        left = left.left;
        right = newNode;
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public AVLTreeNode search(int value) {
        if (value == this.val) {
            return this;
        } else if (value < this.val) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public AVLTreeNode searchParent(int value) {
        if ((this.left != null && this.left.val == value) || (this.right != null && this.right.val == value)) {
            return this;
        } else {
            if (value < this.val && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.val && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    public void add(AVLTreeNode node){
        if(node == null) {
            return;
        }

        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);

            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightHeight();
            }
            leftRote();
        }
        else if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRote();
            }
            rightRote();
        }
    }

}