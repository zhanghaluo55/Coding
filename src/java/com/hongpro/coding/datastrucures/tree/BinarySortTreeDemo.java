package com.hongpro.coding.datastrucures.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {

    }
}

class BinarySortTree {
    private SortTreeNode root;
    public void add(SortTreeNode node) {
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
    public int delRightTreeMin(SortTreeNode node) {
        SortTreeNode targetNode = node;
        while(targetNode.left != null) {
            targetNode = targetNode.left;
        }
        delNode(targetNode.val);
        return targetNode.val;
    }

    public SortTreeNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public SortTreeNode searchParent(int value) {
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
            SortTreeNode targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            SortTreeNode parent = searchParent(value);
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

class SortTreeNode {
    int val;
    SortTreeNode left;
    SortTreeNode right;

    public SortTreeNode(int val) {
        this.val = val;
    }

    public SortTreeNode search(int value) {
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

    public SortTreeNode searchParent(int value) {
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

    public void add(SortTreeNode node){
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

    }
}
