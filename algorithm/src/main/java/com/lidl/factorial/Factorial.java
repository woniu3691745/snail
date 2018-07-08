package com.lidl.factorial;

/**
 * 阶乘
 *
 * @author lidongliang
 * @date 2018/7/8 下午4:16
 */
public class Factorial {

    /**
     * 使用循环来计算阶乘
     *
     * @param n 需要计算的阶乘树
     * @return 结果
     */
    private static long factFor(int n) {
        int i;
        long result = 1;
        for (i = 0; i < n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * 使用递归来计算阶乘
     *
     * @param n 需要计算的阶乘树
     * @return 结果
     */
    private static long factRecursion(int n) {
        // n<=1,n!=1;
        if (n <= 1) {
            return 1;
            // n>1;
        } else {
            return n * factRecursion(n - 1);
        }
    }
}
