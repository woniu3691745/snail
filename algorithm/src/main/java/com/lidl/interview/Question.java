package com.lidl.interview;

/**
 * 排序
 *
 * @author 李栋梁
 * @date 2018/7/4 下午4:06
 */
public class Question {

    /**
     * 求1-2+3-4+5-6+7......+n的值
     *
     * @param n 数
     */
    private void method01(int n) {
        {
            if (n <= 0) {
                System.out.println("error: n must > 0");
            }
            if (0 == n % 2)
                System.out.println((n / 2) * (-1));
            else
                System.out.println((n / 2) * (-1) + n);
        }
    }
}
