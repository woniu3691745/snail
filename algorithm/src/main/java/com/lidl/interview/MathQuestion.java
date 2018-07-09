package com.lidl.interview;

/**
 * 数学问题
 *
 * @author 李栋梁
 * @date 2018/7/4 下午4:06
 */
public class MathQuestion {

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
            if (0 == n % 2) {
                System.out.println((n / 2) * (-1));
            } else {
                System.out.println((n / 2) * (-1) + n);
            }
        }
    }

    /**
     * 洗扑克牌
     * <p>
     * 洗扑克牌的原理其实与乱数排列是相同的，都是将一组数字（例如1～N）打乱重新排列，
     * 现要求按照花色来排列扑克牌。
     */
    private static void solitaire() {
        final int N = 52;
        // 扑克牌一共52张
        int[] solitaire = new int[N + 1];
        // 初始化整列
        for (int i = 1; i <= N; i++) {
            solitaire[i] = i;
        }
        // 洗牌
        for (int i = 1; i <= N; i++) {
            // 生成新的52张牌
            int j = (int) (Math.random() * N);
            if (j == 0) {
                j = 1;
            }
            int mid = solitaire[i];
            solitaire[i] = solitaire[j];
            solitaire[j] = mid;
        }
        for (int i = 1; i <= N; i++) {
            // 判断花色 52/13=4
            switch ((solitaire[i] - 1) / 13) {
                case 0:
                    System.out.print("♠️");
                    break;
                case 1:
                    System.out.print("♥️");
                    break;
                case 2:
                    System.out.print("♦️️");
                    break;
                case 3:
                    System.out.print("♣️️");
                    break;
                default:
                    break;
            }
            // 扑克牌数字
            int number = solitaire[i] % 13;
            switch (number) {
                case 0:
                    System.out.print("K ");
                    break;
                case 1:
                    System.out.print("A ");
                    break;
                case 12:
                    System.out.print("Q ");
                    break;
                case 11:
                    System.out.print("J ");
                    break;
                default:
                    System.out.print(number + " ");
                    break;
            }
            // 控制打印行数，每13个数据换一行
            if (i % 13 == 0) {
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Question.solitaire();
    }
}
