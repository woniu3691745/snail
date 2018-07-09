package com.lidl.interview;

import java.util.Stack;

/**
 * 堆的问题
 *
 * @author lidongliang
 * @date 2018-7-6 16:47
 */
public class StackQuestion {

    private static Stack<String> stack = new Stack<>();

    static {
        stack.push("xiaoming1");
        stack.push("xiaoming2");
        stack.push("xiaoming3");
        stack.push("xiaoming4");
    }

    public static void main(String[] args) {
        StackQuestion stackDemo = new StackQuestion();
//        stackDemo.method01();
        String s = "([]){}";
        System.out.println(stackDemo.isMatch(s));
    }

    /**
     * 堆的内置方法
     */
    private void method01() {
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.push("tester01"));
        System.out.println(stack);
    }

    /**
     * 括号匹配问题
     *
     * @param s 括号
     * @return 排序
     */
    private boolean isMatch(String s) {
        if (s.length() == 0) return false;
        Stack<Character> sk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sk.push('(');
            }
            if (s.charAt(i) == ')') {
                if (!sk.isEmpty() && sk.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            }
            if (s.charAt(i) == '[') {
                sk.push('[');
            }
            if (s.charAt(i) == ']') {
                if (!sk.isEmpty() && sk.pop() == '[') {
                    continue;
                } else {
                    return false;
                }
            }
            if (s.charAt(i) == '{') {
                sk.push('{');
            }
            if (s.charAt(i) == '}') {
                if (sk.isEmpty() || sk.pop() != '{') {
                    return false;
                }
            }
        }
        return sk.isEmpty();
    }
}

