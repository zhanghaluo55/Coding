package com.hongpro.coding.atguigu.kmp;

/**
 * @author zhangzihong
 * @version 1.0.0.0
 * @description 暴力匹配法
 * @date 2021/5/8 10:07
 */
public class ViolenceMatch {
    public static void main(String[] args) {

    }

    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int len1 = s1.length;
        int len2 = s2.length;

        int i = 0,j=0;
        while(i <len1 && j < len2) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == len2) {
            return i - j;
        } else {
            return -1;
        }
    }
}
