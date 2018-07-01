package com.lidl.sort;

/**
 * 递归：递归算法即在程序中不断反复调用自身来达到求解问题的方法
 *
 * @author 李栋梁
 * @date 2018/6/29 下午8:37
 */
public class DG {

    public static void main(String[] args) {
        System.out.println("12的阶乘结果是：" + DG.fact(12));
    }

    private static long fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
