package com.lidl.sort;

/**
 * 字符串相关算法题
 *
 * @author 李栋梁
 * @date 2018/6/29 下午10:01
 */
public class StringTest {

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c'};
        StringTest.permutation(str, 0);
    }

    /**
     * 问题：输入一个字符串,打印出该字符串中字符的所有排列
     * 实现思路：就是输入字符串后，通过递归的方式，循环每个位置和其他位置的字符。
     *
     * @param str 字符串
     * @param i   字符串长度
     */
    private static void permutation(char[] str, int i) {

        if (i == str.length - 1) {

            System.out.println("字符串 ：" + String.valueOf(str));

        } else {
            for (int j = i; j < str.length; j++) {

                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                permutation(str, i + 1);

                // 还原上一次排序
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;

            }
        }
    }
}
