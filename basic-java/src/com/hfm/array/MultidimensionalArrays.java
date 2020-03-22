package com.hfm.array;

/**
 * 多维数组
 *
 * @author hfm
 * @version 1.01 2019-10-02
 */
public class MultidimensionalArrays {
    /**
     * 定义一个遍历二维数组的功能函数
     *
     * @param a
     */
    public static void printArr2(int[][] a) {
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ,");
            }
        }
    }

    /**
     * 定义一个函数计算二维数组中的元素的累加和
     *
     * @param a
     * @return
     */
    public static long getSum(int[][] a) {
        // 0. 定义一个结果变量
        long sum = 0L;
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        return sum;
    }

    /**
     * 统计二维数组中元素的个数
     *
     * @param a
     * @return
     */
    public static int getDataCount(int[][] a) {
        // 0. 记录元素个数
        int count = 0;
        // 1. 拆开二维数组
        for (int i = 0; i < a.length; i++) {
            // 2. 拆开一维数组获取数据
            for (int j = 0; j < a[i].length; j++) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 不规则数组 静态初始化
        int[][] arr1 = new int[][]{
                {23, 4, 5},
                {2},
                {4, 5, 78, 56, 90}
        };

        // 规则数组 静态初始化
        int[][] arr2 = new int[][]{
                {23, 4, 5},
                {2, 7, 8},
                {4, 5, 78}
        };

        printArr2(arr1);
        System.out.println();
        System.out.println("累加和是： " + getSum(arr1));
        System.out.println("统计元素个数： " + getDataCount(arr1));
    }
}
