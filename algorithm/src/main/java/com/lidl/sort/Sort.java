package com.lidl.sort;

import java.util.Arrays;

/**
 * 排序
 *
 * @author 李栋梁
 * @date 2018/6/27 下午9:08
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{67, 65, 77, 38, 97, 3, 33, 49};
//        for (i = 0; i < SIZE; i++) {
//            arrays[i] = (int) (100 + Math.random() * (100 + 1));
//        }
        System.out.println("排序前的数组为：" + Arrays.toString(array));
//        bubbleSort(array);
//        selectSort(array);
//        selectSort1(array);
//        insertSort(array);
//        insertSort1(array);
//        shellSort(array);
//        shellSort1(array);
//        quickSort(array, 0, array.length - 1);
//        heapSort(array, array.length);
        heapSort(array);
//        mergerSort(array, array.length);
        System.out.println("排序后的数组为：" + Arrays.toString(array));
    }

    /*冒泡排序*/

    /**
     * 冒泡排序
     * （1）对数组中的各数据，依次比较相邻的两个元素大小；
     * （2）如果前面的数据大于后面的数据，就交换这两个数据。经过第一轮的多次比较排序后，便可将最小的数据拍好；
     * （3）再用同样的方法把剩下的数据逐个进行比较，最后便可按照从小到大的顺序排好数组各个数据。
     *
     * @param a 数组
     */
    private static void bubbleSort(int[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) { // 将剩余的部分再次比较、交换、排序
                if (a[j] > a[j + 1]) { // 将相邻两个数进行比较，较大的数往后冒泡
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
//            System.out.print("第" + i + "步排序结果:");
            for (int anA : a) {
                System.out.print(" " + anA);
            }
            System.out.print("\n");
        }
    }

    /**
     * 一般不用。
     * <p>
     * 将序列中所有元素两两比较，将最大的放在最后面。
     * 将剩余序列中所有元素两两比较，将最大的放在最后面。
     * 重复第二步，直到只剩下一个数。
     * <p>
     * <p>
     * 如何写成代码：
     * <p>
     * 设置循环次数。
     * 设置开始比较的位数，和结束的位数。
     * 两两比较，将最小的放到前面去。
     * 重复2、3步，直到循环次数完毕。
     *
     * @param a 数组
     */
    private static void bubbleSort1(int[] a) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }



    /*选择排序*/

    /**
     * 选择排序
     * （1）首先从原始数组中选择最小的1个数据，将其和位于第1个位置的数据交换；
     * （2）接着从剩下的n-1个数据中选择次小的1个数据，将其和第2个位置的数据交换；
     * （3）然后不断重复上述过程，直到最后两个数据完全交换。
     *
     * @param a 数组
     */
    private static void selectSort(int[] a) {
        int index, temp;
        for (int i = 0; i < a.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < a.length; j++) {
                // 用第 n+1 个和第 n 个比
                if (a[j] < a[index]) {
                    index = j; // 取出最小的
                }
            }
            // 交换两个数
            if (index != i) {
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
            System.out.print("第" + i + "步排序结果：");
            for (int anA : a) {
                System.out.print(" " + anA);
            }
            System.out.print("\n");
        }
    }

    /**
     * 常用于取序列中最大最小的几个数时。
     * <p>
     * (如果每次比较都交换，那么就是交换排序；如果每次比较完一个循环再交换，就是简单选择排序。)
     * <p>
     * 遍历整个序列，将最小的数放在最前面。
     * 遍历剩下的序列，将最小的数放在最前面。
     * 重复第二步，直到只剩下一个数。
     * <p>
     * <p>
     * 如何写成代码：
     * <p>
     * 首先确定循环次数，并且记住当前数字和当前位置。
     * 将当前位置后面所有的数与当前数字进行对比，小数赋值给key，并记住小数的位置。
     * 比对完成后，将最小的值与第一个数的值交换。
     * 重复2、3步。
     *
     * @param a 数组
     */
    private static void selectSort1(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {              // 循环次数
            int key = a[i];
            int position = i;
            for (int j = i + 1; j < length; j++) {      // 选出最小的值和位置
                if (a[j] < key) {
                    key = a[j];                         // 最小的值
                    position = j;                       // 最小的位置
                }
            }
            a[position] = a[i];                         // 交换位置
            a[i] = key;
        }
    }



    /*插入排序*/

    /**
     * 插入排序
     * （1）首先对数组的前两个数据进行从小到大的排序；
     * （2）接着将第3个数据与排好的前两个数据比较，将第3个数据插入合适的位置；
     * （3）然后，将第4个数据插入已排好的前3个数据中；
     * （4）不断重复上述过程，直到把最后一个数据插入合适的位置。
     *
     * @param a 数组
     */
    private static void insertSort(int[] a) {
        int i, j, t;
        for (i = 1; i < a.length; i++) {
            t = a[i];   // 保存第2个变量
            j = i - 1;
            while (j >= 0 && t < a[j]) {    // n < n-1
                a[j + 1] = a[j];    // n-1个和n交换位置
                j--;
            }
            a[j + 1] = t;
            System.out.print("第" + i + "步排序结果：");
            for (int anA : a) {
                System.out.print(" " + anA);
            }
            System.out.print("\n");
        }
    }

    /**
     * 直接插入排序
     * 经常碰到这样一类排序问题：把新的数据插入到已经排好的数据列中。
     * <p>
     * 将第一个数和第二个数排序，然后构成一个有序序列
     * 将第三个数插入进去，构成一个新的有序序列。
     * 对第四个数、第五个数……直到最后一个数，重复第二步。
     * <p>
     * <p>
     * 如何写成代码：
     * <p>
     * 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
     * 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
     * <p>
     * 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
     * <p>
     * 将当前数放置到空着的位置，即j+1。
     *
     * @param a 数组
     */
    private static void insertSort1(int[] a) {
        int length = a.length;                      // 数组长度，将这个提取出来是为了提高速度。
        int insertNum;                              // 要插入的数
        for (int i = 1; i < length; i++) {          // 插入的次数
            insertNum = a[i];                       // 要插入的数
            int j = i - 1;                          // 已经排序好的序列元素个数
            while (j >= 0 && a[j] > insertNum) {    // 序列从后到前循环，将大于insertNum的数向后移动一格
                a[j + 1] = a[j];                    // 元素移动一格
                j--;                                // 元素前一个位置
            }
            a[j + 1] = insertNum;                   // 将需要插入的数放在要插入的位置。
        }
    }


    /*希尔排序*/

    /**
     * shell(希尔排序)
     * （1）将有n个元素的数组分成n/2个数字序列，第1个数据和第n/2+1个数据为一对，....；
     * （2）一次循环使每一个序列对排好顺序；
     * （3）然后，再变成n/4个序列，再次排序；
     * （4）不断重复上述过程，随着序列减少最后变为一个，也就完成了整个排序。
     *
     * @param a 数组
     */
    private static void shellSort(int[] a) {
        int i, j, r, temp;
        int x = 0;
        for (r = a.length / 2; r >= 1; r /= 2) {
            for (i = r; i < a.length; i++) {
                temp = a[i];
                j = i - r;
                while (j >= 0 && temp < a[j]) {
                    a[j + r] = a[j];
                    j -= r;
                }
                a[j + r] = temp;
            }
            x++;
            System.out.print("第" + x + "步排序结果：");
            for (int anA : a) {
                System.out.print(" " + anA);
            }
            System.out.print("\n");
        }
    }

    /**
     * 希尔排序
     * 对于直接插入排序问题，数据量巨大时。
     * <p>
     * 将数的个数设为n，取奇数k=n/2，将下标差值为k的书分为一组，构成有序序列。
     * 再取k=k/2 ，将下标差值为k的书分为一组，构成有序序列。
     * 重复第二步，直到k=1执行简单插入排序。
     * <p>
     * <p>
     * 如何写成代码：
     * <p>
     * 将数的个数设为n，取奇数k=n/2，将 下标差值 为k的树分为一组，构成有序序列。
     * 再取k=k/2 ，将 下标差值 为k的数分为一组，构成有序序列。
     * 重复第二步，直到k=1执行简单插入排序。
     *
     * @param a 数组
     */
    private static void shellSort1(int[] a) {
        int d = a.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {                           // 分的组数
                for (int i = x + d; i < a.length; i += d) {         // 组中的元素，从第二个数开始
                    int j = i - d;                                  // j为有序序列最后一位的位数，第一位开始有序
                    int temp = a[i];                                // 要插入的元素
                    while (j >= 0 && temp < a[j]) {                 // 从后往前遍历。
                        a[j + d] = a[j];                            // 向后移动d位
                        j -= d;
                    }
                    a[j + d] = temp;
                }
            }
        }
    }



    /*快速排序*/

    /**
     * 快速排序
     * （1）首先设定一个分界值，通过该分界值将数组分成左右两部分；
     * （2）将大于等于分界值的数据集中到数组右边，小于分界值的数据集中到数组的左边。
     * 此时，左边部分中各元素都小于等于分界值，而右边部分中各元素都大于等于分界值；
     * （3）然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，
     * 将该部分数据分成左右两部分，同样将左边放置较小值，右边放置较大值。右边的数组数据
     * 也可以做类似的工作；
     * （4）重复上述过程，可以看出，这是一个递归定义。
     *
     * @param a     数组
     * @param left  左侧第一个
     * @param right 右侧第一个
     */
    private static void quickSort(int[] a, int left, int right) {
        int index, t;
        int rtemp, ltemp;
        ltemp = left;
        rtemp = right;
        index = a[(left + right) / 2];  // 任意数为中间位置
        while (ltemp < rtemp) {
            while (a[ltemp] < index) {  // 从左往右找到第一个大于key的数
                ++ltemp;    // 记录位置
            }
            while (a[rtemp] > index) {  // 从右往左找到第一个小于key的数
                --rtemp;    // 记录位置
            }
            if (ltemp <= rtemp) {   // 大于中间值交换小于中间值
                t = a[ltemp];
                a[ltemp] = a[rtemp];
                a[rtemp] = t;
                --rtemp;    // 交换之后进行下一次比较
                ++ltemp;
            }
        }
        if (ltemp == rtemp) {
            ltemp++;
        }
        if (left < rtemp) { // 左侧
            quickSort(a, left, ltemp - 1);
        }
        if (ltemp < right) { // 右侧
            quickSort(a, rtemp + 1, right);
        }
    }

    /**
     * 要求时间最快时。
     * <p>
     * 选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
     * 递归的将p左边和右边的数都按照第一步进行，直到不能递归。
     *
     * @param numbers 数据
     * @param start   开始位置
     * @param end     结束位置
     */
    private static void quickSort1(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start];      // 选定的基准值（第一个数值作为基准值）
            int temp;                       // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort1(numbers, start, j);
            if (end > i)
                quickSort1(numbers, i, end);
        }
    }



    /*堆排序*/

    /**
     * 堆排序
     * 基于选择排序思想的算法，其利用堆结构和二叉树的一些性质来完成数据的排序。
     * <p>
     * * * * * * * * * *
     * Parent(i)=i/2
     * Left(i)=2*i
     * Right(i)=2*i+1
     * * * * * * * * * *
     * <p>
     * <p>
     * 左子树小于右子树
     * 本题结点是从0开始的
     * <p>
     * （1）如果按照从小到大的顺序排序，要求非叶子结点的数据要大于或等于其左、右子结点的数据；
     * （2）如果按照从大到小的顺序排序，要求非叶子结点的数据要小于或等于其左、右子结点的数据。
     * <p>
     * 一个完整的堆排序需要经过反复的两个步骤：构造堆结构和堆排序输出。
     *
     * @param a 数组
     * @param n 最大根结点
     */
    private static void heapSort(int[] a, int n) {
        int i, j, k;
        int t;
        // 构造堆结构
        for (i = n / 2 - 1; i >= 0; i--) {  // 将a[0,n-1]建成大根堆
            while (2 * i + 1 < n) {
                j = 2 * i + 1;  // 第i个结点的左子树
                if ((j + 1) < n) {  // 第i个结点的右子树
                    if (a[j] < a[j + 1]) {
                        j++;
                    }
                }
                if (a[i] < a[j]) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    i = j;
                } else {
                    break;
                }
            }
        }
        System.out.print("原数据构成的堆：");
        for (int l = 0; l < n; l++) {
            System.out.print(" " + a[l]);
        }
        System.out.print("\n");

        // 堆排序
        for (i = n - 1; i > 0; i--) {
            t = a[0];
            a[0] = a[i];
            a[i] = t;
            k = 0;
            while (2 * k + 1 < i) {
                j = 2 * k + 1;
                if ((j + 1) < i) {
                    if (a[j] < a[j + 1]) {
                        j++;
                    }
                }
                if (a[k] < a[j]) {
                    t = a[k];
                    a[k] = a[j];
                    a[j] = t;
                    k = j;
                } else {
                    break;
                }
            }
            System.out.print("第" + (n - i) + "步排序结果：");
            for (int l = 0; l < n; l++) {
                System.out.print(" " + a[l]);
            }
            System.out.print("\n");
        }

    }

    /**
     * 对简单选择排序的优化。
     * <p>
     * 将序列构建成大顶堆。
     * 将根节点与最后一个节点交换，然后断开最后一个节点。
     * 重复第一、二步，直到所有节点断开。
     * <p>
     * 最后一个节点的父节点开始 >> i = (lastIndex - 1) / 2
     * k节点的左子节点的索引 >> int biggerIndex = 2 * k + 1;
     *
     * @param a 数组
     */
    private static void heapSort(int[] a) {
        System.out.println("开始排序");
        int arrayLength = a.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            // 对data数组从0到lastIndex建大顶堆
            buildMaxHeap(a, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素，之后重新建堆
            swap(a, 0, arrayLength - 1 - i);
            System.out.println(Arrays.toString(a));
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private static void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }




    /*合并排序*/

    /**
     * @param a   原始数组
     * @param b   新数组
     * @param n   原数组长度
     * @param len 按照长度为len的有序表
     */
    private static void mergeOne(int[] a, int[] b, int n, int len) {
        int i, j, k, s, e;
        s = 0;
        while (s + len < n) {
            e = s + 2 * len - 1;    // 计算数组下标
            if (e >= n) {   // 最后一段可能少于len个结点
                e = n - 1;
            }

            k = s;  // 用于b段的下标
            i = s;  // n段的下标
            j = s + len;    //n+len段下标
            while (i < s + len && j <= e) { // 如果两个有序段都未结束时，循环比较
                if (a[i] <= a[j]) { // 较小的元素复制到数组b中
                    b[k++] = a[i++];
                } else {
                    b[k++] = a[j++];
                }
            }
            while (i < s + len) {   // 未合并的部分复制到数组b中
                b[k++] = a[i++];
            }
            while (j <= e) {    // 未合并的部分复制到数组b中
                b[k++] = a[j++];
            }
            s = e + 1;  // 下一对有序段中左段的开始下标
        }
        if (s < n) {    // 将剩余的一个有序段从数组A中复制到数组B中
            for (; s < n; s++) {
                b[s] = a[s];
            }
        }
    }

    /**
     * 合并排序
     * 合并排序算法就是将多个有序
     *
     * @param a 数组
     * @param n 数组长度
     */
    private static void mergerSort(int[] a, int n) {
        int h, count, len, f;
        count = 0;
        len = 1;    // 有序序列的长度
        f = 0;
        int[] p = new int[n];   // 临时数组
        while (len < n) {
            if (f == 1) {
                mergeOne(p, a, n, len);
            } else {
                mergeOne(a, p, n, len);
            }
            len = len * 2;  // 增加有序序列长度
            f = 1 - f;
            count++;
            System.out.print("第" + count + "步排序结果：");
            for (h = 0; h < a.length; h++) {
                System.out.print(" " + a[h]);
            }
            System.out.print("\n");
        }
        if (f == 1) {
            for (h = 0; h < n; h++) {
                a[h] = p[h];
            }
        }
    }

    /**
     * 速度仅次于快排，内存少的时候使用，可以进行并行计算的时候使用。
     * <p>
     * 选择相邻两个数组成一个有序序列。
     * 选择相邻的两个有序序列组成一个有序序列。
     * 重复第二步，直到全部组成一个有序序列。
     *
     * @param numbers 数据
     * @param left    左侧
     * @param right   右侧
     */
    public static void mergeSort1(int[] numbers, int left, int right) {
        int t = 1;              // 每组元素个数
        int size = right - left + 1;
        while (t < size) {
            int s = t;          // 本次循环每组元素个数
            t = 2 * s;
            int i = left;
            while (i + (t - 1) < size) {
                merge1(numbers, i, i + (s - 1), i + (t - 1));
                i += t;
            }
            if (i + (s - 1) < right)
                merge1(numbers, i, i + (s - 1), right);
        }
    }

    private static void merge1(int[] data, int p, int q, int r) {
        int[] B = new int[data.length];
        int s = p;
        int t = q + 1;
        int k = p;
        while (s <= q && t <= r) {
            if (data[s] <= data[t]) {
                B[k] = data[s];
                s++;
            } else {
                B[k] = data[t];
                t++;
            }
            k++;
        }
        if (s == q + 1)
            B[k++] = data[t++];
        else
            B[k++] = data[s++];
        int i = p;
        while (i <= r) {
            data[i] = B[i];
            i++;
        }
    }

}
