package com.hongpro.coding.datastrucures.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};



    }

    public static HuffmanNode createHuffmanTree(int[] arr) {
        List<HuffmanNode> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new HuffmanNode(val));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            HuffmanNode left = nodes.get(0);
            HuffmanNode right = nodes.get(1);
            HuffmanNode parent = new HuffmanNode(left.value + right.value);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


}
class HuffmanNode implements Comparable<HuffmanNode> {
    int value;
    HuffmanNode left;
    HuffmanNode right;
    char c;

    public void preOrder() {
        System.out.println(this.value);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;
    }
}
