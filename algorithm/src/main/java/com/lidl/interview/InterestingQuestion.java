package com.lidl.interview;

/**
 * 经典趣题
 *
 * @author lidongliang
 * @date 2018/7/8 下午5:36
 */
public class InterestingQuestion {

    /**
     * 百钱买百鸡
     * x+y+z=100
     * 5x+3y+z/3=100
     *
     * @param m 钱
     * @param n 鸡
     */
    private static void bjbj(int m, int n) {
        int x, y, z;
        for (x = 0; x <= n; x++) {
            for (y = 0; y <= n; y++) {
                z = n - x - y;
                if (z > 0 && z % 3 == 0 && x * 5 + y * 3 + z / 3 == m) {
                    System.out.printf("公鸡：%d只，母鸡：%d只，小鸡：%d只\n", x, y, z);
                }
            }
        }
    }

    /**
     * 五家共井
     * len1*2+len2=len
     * len2*3+len3=len
     * len3*4+len4=len
     * len4*5+len5=len
     * len5*6+len1=len
     * <p>
     * 变形
     * len1*2+len2=len2*3+len3=len3*4+len4=len4*5+len5=len5*6+len1
     * len1=len2+len3/2
     * len2=len3+len4/3
     * len3=len4+len5/4
     * len4=len5+len1/5
     * 由此可知
     * len3能被2整除，len3必为2的倍数；
     * len4能被3整除，len4必为3的倍数；
     * len5能被4整除，len5必为4的倍数；
     * len1能被5整除，len1必为5的倍数；
     *
     * @param len1 甲
     * @param len2 已
     * @param len3 丙
     * @param len4 丁
     * @param len5 戊
     * @param len  井深
     */
    private static void wjgj(int[] len1, int[] len2, int[] len3, int[] len4, int[] len5, int[] len) {
        for (len5[0] = 4; ; len5[0] += 4) {
            for (len1[0] = 5; ; len1[0] += 5) {
                len4[0] = len5[0] + len1[0] / 5;
                len3[0] = len4[0] + len5[0] / 4;
                if (len3[0] % 2 != 0 || len4[0] % 3 != 0) {
                    continue;
                }
                len2[0] = len3[0] + len4[0] / 3;
                if (len2[0] + len3[0] / 2 < len1[0]) {
                    break;
                }
                if (len2[0] + len3[0] / 2 == len1[0]) {
                    len[0] = 2 * (len1[0]) + (len2[0]);
                    return;
                }
            }
        }
    }

    /**
     * 汉诺塔问题
     * 利用汉诺塔函数求取不同盘子数的移动步骤
     *
     * @param n  盘子的数量
     * @param p1 第一个
     * @param p2 第二个
     * @param p3 第三个
     */
    private static void hannoi(int n, int p1, int p2, int p3) {
        if (n == 1) {
            System.out.println("盘子从 " + p1 + " 移到 " + p3);
        } else {
            hannoi(n - 1, p1, p3, p2);
            System.out.println("盘子从 " + p1 + " 移到 " + p3);
            hannoi(n - 1, p2, p1, p3);
        }
    }

    public static void main(String[] args) {
//        InterestingQuestion.bjbj(100, 100);
//        int[] len1 = {0};
//        int[] len2 = {0};
//        int[] len3 = {0};
//        int[] len4 = {0};
//        int[] len5 = {0};
//        int[] len = {0};
//        InterestingQuestion.wjgj(len1, len2, len3, len4, len5, len);
//        System.out.printf("井深：%d\n", len[0]);
        hannoi(3, 1, 2, 3);
    }
}
