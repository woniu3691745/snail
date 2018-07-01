package com.lidl.sort;

/**
 * 穷举算法：穷举算法效率并不高，但是适合于一些没有明显规律可循的场合
 * 鸡兔问题
 *
 * @author 李栋梁
 * @date 2018/6/29 下午8:19
 */
public class QJ {

    public static void main(String[] args) {
        QJ.jitu(35, 94);
    }

    /**
     * 鸡兔问题
     * <p>
     * 35个头，94只脚，问鸡兔的数量各多少？
     *
     * @param head 头
     * @param foot 脚
     * @return
     */
    private static void jitu(int head, int foot) {

        int i, j;   // i ：鸡的头数
        for (i = 0; i <= head; i++) {
            j = head - i;   // 总头数 - 鸡的头数
            if (i * 2 + j * 4 == foot) {
                System.out.println("🐔 = " + i);
                System.out.println("🐰 = " + j);
            }
        }
    }
}
