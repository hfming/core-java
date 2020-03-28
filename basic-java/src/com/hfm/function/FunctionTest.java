package com.hfm.function;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author hfm
 * @version 1.01 2020/3/25
 */
public class FunctionTest {

    public static void main(String[] args) {
        int i = "sdsd".length();
        // char c = 17c;
        System.out.println(i);
        getMax("aaaaaaaaaabbbbbbbbbbsfuudiigjuaggrwyrochnbgdsyugfejrojighdcdkirherue");
        getNum(111);
        primeNum(100);
    }

    public static void getMax(String str) {
        char[] chars = str.toCharArray();
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (int i = 0; i < chars.length; i++) {
            String string = String.valueOf(chars[i]);
            if (hashmap.containsKey(string)) {
                hashmap.put(string, hashmap.get(string) + 1);
            } else {
                hashmap.put(string, 1);
            }
        }
        Collection<Integer> values = hashmap.values();
        System.out.println(values);
        int max = 0;
        //求最大的个数
        for (int i : values) {
            if (max < i) {
                max = i;
            }
        }
        Set<Entry<String, Integer>> outString = hashmap.entrySet();
        for (Entry<String, Integer> i : outString) {
            if (i.getValue() == max) {
                System.out.println(i.getKey() + "=" + max);
            }
        }
    }

    public static void getAllArr(int[] arr) {

    }

    public static void getNum(int n) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            int j = getDivisor(i);
            // System.out.println("j="+j);
            temp = i;
            for (int x = j; x >= 0; x--) {
                // System.out.println("x="+x);
                // System.out.println("pow="+(int)Math.pow(10, x));
                // System.out.println("/="+(i/(int)Math.pow(10, x)));
                if ((temp / (int) Math.pow(10, x)) == 1) {
                    result = result + 1;
                }
                temp = (i % (int) Math.pow(10, x));
            }
        }
        // System.out.println(result);
    }

    private static int getDivisor(int n) {
        int i = 0;
        do {
            // System.out.println((int)Math.pow(10, i));
            if ((n / (int) Math.pow(10, i)) >= 10) {
                i++;
            } else {
                break;
            }
        } while (true);
        // System.out.println(i);
        return i;
    }

    public static void primeNum(int n) {
        OUT:
        for (int i = 1; i <= n; i++) {
            INNER:
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && j != 1) {
                    continue OUT;
                }
            }
            System.out.print(i + " ");
        }
    }

    /**
     * 选择排序/快速排序
     */
    public static void quickSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
