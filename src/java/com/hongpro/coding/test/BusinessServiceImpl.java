package com.hongpro.coding.test;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description
 * @date 2021/11/17 11:29
 */
public class BusinessServiceImpl implements BusinessService {
    @Override
    public TreeNode getTreeNode() {
        TreeNode root = new TreeNode();

        TreeNode leftC = new TreeNode();
        TreeNode rightC = new TreeNode();
        leftC.setValue(15);
        leftC.setPriority(3);
        leftC.setLabel("C");
        rightC.setValue(16);
        rightC.setPriority(4);
        rightC.setLabel("C");

        TreeNode leftB = new TreeNode();
        TreeNode rightB = new TreeNode();
        leftB.setLeft(leftC);
        rightB.setRight(rightC);
        leftB.setValue(13);
        leftB.setPriority(2);
        leftB.setLabel("B");
        rightB.setValue(14);
        rightB.setPriority(1);
        rightB.setLabel("B");

        TreeNode leftA = new TreeNode();
        TreeNode rightA = new TreeNode();
        leftA.setLeft(leftB);
        rightA.setRight(rightB);

        root.setLeft(leftA);
        root.setRight(rightA);
        return root;
    }
}
