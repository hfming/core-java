package com.hfm.array;

/**
 * 自定义 Arrays
 *
 * @author hfm
 * @version 1.01 2020-03-19 18:48
 * @date 2020/3/19
 */
public class MyArrays {
    /**
     * 简单选择排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * toString 打印功能
     *
     * @param arr
     */
    public static void toString(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.println("[" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.println(arr[i] + "]");
            } else {
                System.out.println(arr[i] + ",");
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp = 0;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 翻转数组
     */
    public static void reversal(int[] arr) {
        for (int start = 0, end = arr.length - 1; start > end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    /**
     * 数组求和
     */
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 定义一个获取数组最大值的功能函数
     */
    public static int getMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;

    }

    /**
     * 定义一个获取数组最大值角标的功能函数
     */
    public static int getMaxNum(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[num] > arr[i]) {
                num = i;
            }
        }
        return num;
    }

    /**
     * 定义一个返回指定数在指定数组中包含的角标的功能函数
     */
    public static void getNum(int[] arr, int n) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]) {
                flag = true;
                System.out.println(i);
            }
        }
        if (flag == false) {
            System.out.println(-1);
        }
    }

    /**
     * 功能：除去数组中为0的元素，返回新的数组
     *
     * @param arr
     * @return
     */
    public static int[] removeZreo(int[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        int[] newArray = new int[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    /**
     * removeZreo float 重载
     *
     * @param arr
     * @return
     */
    public static float[] removeZreo(float[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        float[] newArray = new float[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0F) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    /**
     * removeZreo double 重载
     *
     * @param arr
     * @return
     */
    public static double[] removeZreo(double[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        double[] newArray = new double[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0.0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    /**
     * removeZreo byte 重载
     *
     * @param arr
     * @return
     */
    public static byte[] removeZreo(byte[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        byte[] newArray = new byte[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    /**
     * removeZreo long 重载
     *
     * @param arr
     * @return
     */
    public static long[] removeZreo(long[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        long[] newArray = new long[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0L) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    /**
     * removeZreo short 重载
     *
     * @param arr
     * @return
     */
    public static short[] removeZreo(short[] arr) {
        int zeroNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroNumber++;
            }
        }
        int index = 0;
        short[] newArray = new short[arr.length - zeroNumber];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                newArray[index] = arr[i];
                index++;
            }
        }
        return newArray;
    }

    /**
     * 清除重复元素。 int[] oldArr = {1,4，9,4,1,1,7}； 把非重复元素存储到一个新的数组中返回，而且也是不能浪费长度
     *
     * @param arg
     * @return
     */
    private static int[] clearRepetition(int[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        int[] result = new int[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition short 重载
     *
     * @param arg
     * @return
     */
    private static short[] clearRepetition(short[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        short[] result = new short[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition byte 重载
     *
     * @param arg
     * @return
     */
    private static byte[] clearRepetition(byte[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        byte[] result = new byte[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition long 重载
     *
     * @param arg
     * @return
     */
    private static long[] clearRepetition(long[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        long[] result = new long[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition float 重载
     *
     * @param arg
     * @return
     */
    private static float[] clearRepetition(float[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        float[] result = new float[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition double 重载
     *
     * @param arg
     * @return
     */
    private static double[] clearRepetition(double[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        double[] result = new double[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition char 重载
     *
     * @param arg
     * @return
     */
    private static char[] clearRepetition(char[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        char[] result = new char[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j] == arg[i]) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition String 重载
     *
     * @param arg
     * @return
     */
    private static String[] clearRepetition(String[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        String[] result = new String[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j].equals(arg[i])) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }

    /**
     * clearRepetition object 重载
     *
     * @param arg
     * @return
     */
    private static Object[] clearRepetition(Object[] arg) {
        int count = 0;
        for (int i = 0; i < arg.length - 1; i++) {
            for (int j = i + 1; j < arg.length; j++) {
                if (arg[i] == arg[j]) {
                    count++;
                    // 重复的只统计一次
                    break;
                }
            }
        }
        Object[] result = new Object[arg.length - count];
        // System.out.println(result.length);
        int num = 0;
        boolean flag;
        for (int i = 0; i < arg.length; i++) {
            flag = false;
            for (int j = 0; j < result.length; j++) {
                if (result[j].equals(arg[i])) {
                    flag = true;
                }
            }
            if (flag == false) {
                result[num] = arg[i];
                num++;
            }
        }
        return result;
    }
}
