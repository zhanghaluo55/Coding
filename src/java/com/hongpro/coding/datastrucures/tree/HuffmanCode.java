package com.hongpro.coding.datastrucures.tree;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 哈夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] contentBytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(contentBytes.length);

        List<HuffmanCodeNode> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        HuffmanCodeNode root = createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(root);
        System.out.println("哈夫曼编码：" + codes);

        byte[] zip = zip(contentBytes, codes);
        System.out.println("huffmanCodeBytes" + Arrays.toString(zip));
    }

    public static void unZipFile(String zipFile, String dstFile) throws IOException, ClassNotFoundException {
        InputStream is = null;
        ObjectInputStream ois = null;
        OutputStream os = null;
        is = new FileInputStream(zipFile);
        ois = new ObjectInputStream(is);
        byte[] huffmanBytes = (byte[])ois.readObject();
        Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
        Byte[] decode = decode(huffmanCodes, huffmanBytes);

        FileOutputStream oss = new FileOutputStream(dstFile);
       // oss.write(decode);
    }

    /**
     * 压缩文件
     * @param srcFile 输入文件路径
     * @param dstFile 输出文件路径
     */
    public static void zipFile(String srcFile, String dstFile) throws IOException {
        FileInputStream is = new FileInputStream(srcFile);
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();

        byte[] huffmanBytes = huffmanZip(b);
        FileOutputStream os = new FileOutputStream(dstFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        objectOutputStream.writeObject(huffmanBytes);
        objectOutputStream.writeObject(huffmanCodes);

    }

    public static Byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));
        }

        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i = 0; i <  stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
                list.add(b);
                i += count;
            }
        }
        return list.toArray(new Byte[0]);
    }

    /**
     * 将一个byte转成二进制的字符串
     * @param flag 标识是否需要补高位
     * @param b 原byte
     * @return byte对应字符串 补码
     */
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        //正数补位
        if (flag) {
            temp |= 256;
        }

        String str = Integer.toBinaryString(temp);

        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }


    public static byte[] huffmanZip(byte[] bytes) {
        List<HuffmanCodeNode> nodes = getNodes(bytes);
        HuffmanCodeNode root = createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(root);
        return zip(bytes, codes);
    }

    /**
     *  将字符串对应的byte[]数组通过生成哈夫曼编码表，返回一个哈夫曼编码，压缩后的byte[]
     * @param bytes 原始字串对应的byte[]
     * @param huffmanCodes 生成的哈夫曼编码
     * @return 哈夫曼编码处理后的byte[]
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder stringBuilder1 = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder1.append(huffmanCodes.get(b));
        }

        int len = stringBuilder1.length() % 8 == 0 ? stringBuilder1.length() / 8 : stringBuilder1.length() / 8 + 1;
        int index = 0;

        byte[] huffmanBytes = new byte[len];
        for (int i = 0; i < stringBuilder1.length(); i += 8) {
            String strByte;
            if (i + 8 >stringBuilder1.length()) {
                strByte = stringBuilder1.substring(i);
            } else {
                strByte = stringBuilder1.substring(i, i + 8);
            }

            huffmanBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanBytes;
    }

    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    private static Map<Byte, String> getCodes(HuffmanCodeNode node) {
        if (node == null) {
            return null;
        }
        getCodes(node, "", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 将传入的node节点的所有叶子节点的哈夫曼编码拿到，放入huffmanCodes集合
     * @param node 传入节点
     * @param code 路径： 左子节点 0 右子节点 1
     * @param stringBuilder 用于拼接路径
     * @return
     */
    private static void getCodes(HuffmanCodeNode node, String code, StringBuilder stringBuilder) {
        stringBuilder.append(code);
        if (node != null) {
            //非叶子节点
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder);
                getCodes(node.right, "1", stringBuilder);
            } else {
                huffmanCodes.put(node.data, stringBuilder.toString());
            }
        }
    }


    public static HuffmanCodeNode createHuffmanTree(List<HuffmanCodeNode> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);

            HuffmanCodeNode left = nodes.get(0);
            HuffmanCodeNode right = nodes.get(1);

            HuffmanCodeNode parent = new HuffmanCodeNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }

        return nodes.get(0);
    }

    /**
     * 接收字节数组返回list
     * @param bytes
     * @return
     */
    public static List<HuffmanCodeNode> getNodes(byte[] bytes) {
        ArrayList<HuffmanCodeNode> nodes = new ArrayList<>();

        Map<Byte, Integer> contents = new HashMap<>();
        for (byte b : bytes) {
            Integer count = contents.getOrDefault(b, 0);
            contents.put(b, count + 1);
        }


        for (Map.Entry<Byte, Integer> entry : contents.entrySet()) {
            nodes.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }
}

class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    Byte data;
    int weight;
    HuffmanCodeNode left;
    HuffmanCodeNode right;

    public HuffmanCodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

}
