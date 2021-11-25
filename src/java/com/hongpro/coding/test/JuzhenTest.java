package com.hongpro.coding.test;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description:
 * @Author: zhangzihong
 * @CreateTime: 2021/9/10
 * @Version:
 */
public class JuzhenTest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            LinkedList<int[]> list = new LinkedList<>();

            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                list.add(new int[]{a,b});
            }
            int count = 0;
            char cs[] = sc.next().toCharArray();
            Stack<Character> s = new Stack<>();
            int idx = 0;
            for(int i=0;i<cs.length;i++){
                if(cs[i]!=')'){
                    s.push(cs[i]);
                    if(Character.isLetter(cs[i])){
                        idx++;
                    }
                }else{
                    s.pop();
                    char c1 = s.pop();
                    idx -= 2;
                    while(!s.isEmpty()&&s.peek()=='(')
                        s.pop();

                    int[] m1 = list.get(idx);
                    int[] m2 = list.get(idx+1);

                    list.remove(idx);
                    list.remove(idx);

                    s.push(c1);
                    idx ++;

                    list.add(idx-1,new int[]{m1[0],m2[1]});
                    count += (m1[0]*m1[1]*m2[1]);
                }
            }
            System.out.println(count);

        }
    }
}
