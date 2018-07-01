package com.lidl.sort;

/**
 * 递推：递推算法适用于有明显规律的场合
 *
 * @author 李栋梁
 * @date 2018/6/29 下午8:29
 */
public class DT {

    public static void main(String[] args) {
        System.out.println("经过12个月，共繁殖" + DT.fibonacci(12) + "只兔子。");
    }

    /**
     * 第n个月兔子总数 Fn=Fn-2+Fn-1
     *
     * @param n 月数
     * @return
     */
    private static int fibonacci(int n) {
        int t1, t2;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            t1 = fibonacci(n - 1);
            t2 = fibonacci(n - 2);
            return t1 + t2;
        }
    }
}
