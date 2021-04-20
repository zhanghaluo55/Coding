package com.hongpro.coding.datastrucures.stack;

import java.util.Stack;

/**
 * TODO
 *
 * @author zhangzihong
 * @data 2021/3/22 15:05
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.list();

        calculator();
    }

    public static void calculator() {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        String calStr = "3/3+2*3+2";
        int index = 0;
        String keepNum = "";
        while(index < calStr.length()) {
            char c = calStr.substring(index, index + 1).charAt(0);
            if (isOperate(c)) {
                if (charStack.isEmpty()) {
                    charStack.add(c);
                } else {
                    if ( priority(charStack.peek()) >= priority(c)) {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int res = cal(num1, num2, charStack.pop());
                        numStack.push(res);
                        charStack.push(c);
                    } else {
                        charStack.push(c);
                    }
                }
            } else {
                keepNum += c;
                if (index == calStr.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (isOperate(calStr.substring(index+1, index+2).charAt(0))) {
                        numStack.add(Integer.valueOf(String.valueOf(c)));
                        keepNum = "";
                    }
                }
            }
            index++;
        }

        while (!charStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char c = charStack.pop();
            int res = cal(num1, num2, c);
            numStack.push(res);
        }

        System.out.println("result = " + numStack.pop());

    }

    public static int cal(int num1, int num2, int operate) {
        int res = 0;
        switch (operate) {
            case '+' :
                res = num1 + num2;
                break;
            case '-' :
                res = num2 - num1;
                break;
            case '*' :
                res = num1 * num2;
                break;
            case '/' :
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public static boolean isOperate(int operate) {
        return operate == '+' || operate == '-' || operate == '*' || operate == '/';
    }

    public static int priority(int operate) {
        if (operate == '*' || operate == '/') {
            return 1;
        } else if (operate == '+' || operate == '-') {
            return 0;
        }
        return -1;
    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == (maxSize - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈满了");
        }
        return stack[--top];
    }

    public void list(){
        if (isEmpty()) {
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d] = %d\n",  i, stack[i]);
        }
    }
}
