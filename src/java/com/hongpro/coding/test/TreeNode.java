package com.hongpro.coding.test;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/11/17 11:29
 */
public class TreeNode {
    private TreeNode left;

    private TreeNode right;

    private Integer value;

    private Integer priority;

    private String label;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
