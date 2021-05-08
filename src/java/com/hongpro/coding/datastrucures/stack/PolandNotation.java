package com.hongpro.coding.datastrucures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * TODO 逆波兰表达式
 *
 * @author zhangzihong
 * @data 2021/3/22 16:54
 */
public class PolandNotation {
    public static void main(String[] args) {
        String expression = "1+(50-2)*2+((15+5)/5+1)";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式:" + infixExpressionList);
        List<String> suffixExpression = parseSuffixExpression(infixExpressionList);
        System.out.println("后缀表达式:" + suffixExpression);
    }

    public static List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        for (String s : ls) {
            if (s.matches("\\d+")) {
                list.add(s);
            } else if(s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                stack.pop();
            } else {
                while (list.size() != 0 && !stack.isEmpty() && Operation.getValue(stack.peek()) >= Operation.getValue(s)) {
                    list.add(stack.pop());
                }
                stack.push(s);
            }
        }

        while (stack.size() != 0) {
            list.add(stack.pop());
        }

        return list;
    }

    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index);

                if (!Character.isDigit(c)) {
                    list.add(String.valueOf(c));
                    index++;
                } else {
                    String str = "";
                    c = s.charAt(index);
                    while (index < s.length() && Character.isDigit(s.charAt(index))) {
                        c = s.charAt(index);
                        str += c;
                        index++;
                    }
                    list.add(str);
                }
        }
        return list;
    }

    public static int calculator(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String string : list) {
            if (string.matches("\\d+")) {
                stack.push(string);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (string.equals("+")) {
                    res = num1 + num2;
                } else if (string.equals("-")) {
                    res = num2 - num1;
                } else if (string.equals("*")) {
                    res = num1 * num2;
                } else if (string.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算有误!");
                }
                stack.push("res" + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = Arrays.asList(split);
        return list;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String c) {
        int result = 0;
        switch (c) {
            case "+" :
                result = ADD;
                break;
            case "-" :
                result = SUB;
                break;
            case "*" :
                result = MUL;
                break;
            case "/" :
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
