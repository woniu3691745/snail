package com.lidl.search;

/**
 * 查找
 *
 * @author lidongliang
 * @date 2018/7/8 下午2:54
 */
public class Search {

    /**
     * 顺序查找
     *
     * @param a 数据序列数组
     * @param n 数组长度
     * @param x 待查找的数据
     * @return 结果
     */
    private static int searchFun(int[] a, int n, int x) {
        int i, f = -1;
        for (i = 0; i < n; i++) {
            if (x == a[i]) {
                f = i;
                break;
            }
        }
        return f;
    }

    /**
     * 二分查找
     * O(nlog2n)
     *
     * @param a 数据序列数组
     * @param n 数组长度
     * @param x 待查找的数据
     * @return 结果
     */
    private static int binarySearchFun(int[] a, int n, int x) {
        int mid, low, high;
        // 首位
        low = 0;
        // 末尾
        high = n - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] array = new int[]{3, 12, 31, 42, 54, 59, 69, 77, 90, 97};
        System.out.println(Search.searchFun(array, 10, 54));
        System.out.println(Search.binarySearchFun(array, 10, 54));
    }


    /*
        顺序表：
        顺序表结构是典型的线性表结构，顺序表再存储时才有结构数组的形式。顺序表结构中的查找算法就是查找数据结点，并返回该结点
        在线性表中的位置。如果在线性表中没有找到值为x的结点，则返回一个错误标志。根据值x类型的不同，查找结点可以分为按照序号
        查找结点和按照关键字查找结点。
     */

    /*
        树：
        树结构是一种描述非线性层次关系的数据结构，其中最为重要的便是二叉树。查找结点就是遍历二叉树中的每一个结点，逐个比较数据，
        当找到目标数据时返回该数据所在结点的指针。
     */



}
