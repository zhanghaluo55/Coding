package com.hongpro.coding.test;

import java.util.Scanner;

/**
 * @Description:
 * @Author: zhangzihong
 * @CreateTime: 2021/9/9
 * @Version:
 */
public class IPChangeTest {
    public static void main(String[] args){
        String str1 = Integer.toBinaryString(Integer.parseInt("1"));
        str1 = String.format("%08d", Integer.parseInt(str1));
        System.out.println(str1);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] ip = scanner.nextLine().split("\\.");
            String binary = "";
            for (String str : ip) {
                String temp = Integer.toBinaryString(Integer.parseInt(str));
                for (int i = temp.length(); i < 8; i++) {
                    temp = "0" + temp;
                }
                binary += temp;
            }
            char[] c = binary.toCharArray();
            System.out.println(toDec(c));
            long in = Long.parseLong(scanner.nextLine());
            String bin = Long.toBinaryString(in);
            for (int i = bin.length(); i < 32; i++) {
                bin = "0" + bin;
            }
            //System.out.println(bin);
            String out = "";
            for (int i = 0; i < 4; i++) {
                out += toDec(bin.substring(i*8, i*8 + 8).toCharArray()) + (i == 3 ? "" : ".");
            }
            System.out.println(out);
        }
        scanner.close();
    }

    public static String toDec(char[] in) {
        long out = 0L;
        long one = 1L;
        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] == '1') out += (one<<(in.length-1-i));
        }
        return out+"";
    }
}
