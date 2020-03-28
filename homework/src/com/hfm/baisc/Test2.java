package com.hfm.baisc;

public class Test2 {
    public static void main(String[] args) {
        char digit = 'a';
        for (int i = 0; i < 10; i++) {
            switch (digit) {
                case 'x': {
                    int j = 0;
                    System.out.println(j);
                }
                default: {
                    int j = 100;
                    System.out.println(j);
                }
            }
        }
        int[] arr = new int[10];
        System.out.println(arr[0]);
    }
}
