package com.lidl.collection;

import java.util.Arrays;

/**
 * 数组一些方法
 *
 * @author lidongliang
 * @date 2018-7-6 16:40
 */
public class Array {

    private int[] listData = new int[]{67, 65, 77, 38, 97, 3, 33, 49};

    public static void main(String[] args) {
        Array array = new Array();
//        array.binarySearchMethod();
//        array.fillMethod();
//        array.randomMethod();
//        array.linkedListMethod();
    }

    private void binarySearchMethod() {
        Arrays.sort(listData);
        int i = Arrays.binarySearch(listData, 49);
        System.out.println(i);
    }

    private void fillMethod() {
        int[] listData = new int[]{67, 65, 77, 38, 97, 3, 33, 49};
        Arrays.fill(listData, 100);
        System.out.println(Arrays.toString(listData));
    }

    private void randomMethod() {
        int[] a = new int[10];
        a[0]++;

        int[][] i = new int[2][10];

        int intCreate = 20;
        int intRand;
        while (intCreate-- > 0) {
            intRand = (int) (Math.random() * 10);
            System.out.println("intRand = " + intRand);
            i[0][intRand]++;
            i[1][intRand]++;
        }
//        Arrays.sort(i[0]);
        for (int j = 9; j >= 0; j--) {
            System.out.print(" " + i[0][j]);
        }
        System.out.println();
        System.out.println(Arrays.toString(i[1]));
    }

}

