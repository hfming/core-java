package com.hfming.baiscjava;

public class Middle extends Top {
    public Middle() {
        super(x);

        x += 1;
    }

    public static void main(String[] args) {
        Middle m = new Middle();
        System.out.println(x);
    }
}
