package com.hfm.innerclass;

/**
 * 静态内部类
 *
 * @author Cay Horstmann
 * @version 1.01 2004-02-27
 */
public class StaticInnerClassTest {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * 一对浮点数
     */
    public static class Pair {
        private double first;
        private double second;

        /**
         * 根据两个浮点数构造一个对
         *
         * @param f the first number
         * @param s the second number
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * 返回该对的第一个数字
         *
         * @return the first number
         */
        public double getFirst() {
            return first;
        }

        /**
         * 返回该对的第二个数字
         *
         * @return the second number
         */
        public double getSecond() {
            return second;
        }
    }

    /**
     * 计算数组的最小值和最大值
     *
     * @param values 浮点数数组
     * @return 一对第一个元素最小，第二个元素最大
     */
    public static Pair minmax(double[] values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        return new Pair(min, max);
    }
}
