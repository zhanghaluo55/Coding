package com.hongpro.coding.test;

import java.util.Scanner;

/**
 * @Description: 合唱队升高排列问题
 * @Author: zhangzihong
 * @CreateTime: 2021/9/8
 * @Version:
 */
public class QueueHeightSortTest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //处理输入
            int n = sc.nextInt();
            int[] height = new int[n];
            for(int i=0; i<n; i++){
                height[i] = sc.nextInt();
            }
            //每个位置左侧最长上升子序列
            int[] numL = new int[n];
            for(int i=0; i<n; i++){
                for(int j=0; j<i; j++){//左侧比height[i]小的位置最长上升序列长度
                    if(height[i]>height[j]) numL[i] = Math.max(numL[i], numL[j]);
                }
                numL[i] += 1;//左侧比height[i]小位置最长上升序列长度+1
            }
            //每个位置右侧最长下降子序列
            int[] numR = new int[n];
            for(int i=n-1; i>=0; i--){
                for(int j=n-1; j>i; j--){//右侧比heigth[i]小的位置最长下降序列长度
                    if(height[i]>height[j]) numR[i] = Math.max(numR[i], numR[j]);
                }
                numR[i] += 1;//右侧比height[i]小位置最长下降序列长度+1
            }
            //根据每个位置最长合唱队numL[i]+numR[i]-1，求出所有位置中最大值
            int maxLen=0;

            for(int i=0; i<n; i++){
                if(numL[i]+numR[i]-1>maxLen) maxLen = numL[i]+numR[i] - 1;
            }
            //最后n-maxLen即为需要出列人数
            System.out.println(n-maxLen);
        }
    }
}
