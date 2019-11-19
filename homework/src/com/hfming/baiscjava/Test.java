package com.hfming.baiscjava;

public class Test {
    public static void main(String[] args) {
/*      boolean x = true;
        boolean y = false;
        short z = 42;
        if ((z++ == 42) && (y = true)) {
            z++;
        }
        if ((x = false) || (++z == 45)) {
            z++;
        }
        System.out.println("z =" + z);*/

        for (int i = 0; i < 10; i++) {
            if (i == 3)
                break;
            System.out.print(i);
        }
        int s[];

        boolean state = false;
        int i = 2;
        if ((++i > 2) && (state = true))
            i++;
        if ((++i > 4) || (state = false))
            i++;
        System.out.println(i);

      /*  int x = 5;
        Integer xl = x;
        Integer x2 = x;
        int x3 = new Integer(5);
        System.out.print(xl.equals(x));
        System.out.print(xl == x);
        System.out.print(x2.equals(xl));
        System.out.print(x2 == xl);
        System.out.print(x2 == x3);
        System.out.print(x2.equals(x3));*/


        int x = 0;
        int y = 4;
        for (int z = 0; z < 3; z++, x++) {
            if (x > 1 & ++y < 10)
                y++;
        }
        System.out.println(y);

//        double d = 0x12345678;

        int num1 = 1;
        int num2 = num1 ++;
        if (num1 == ++num2 && (num1++) == num2) {
            num1 += num2;
        }
        System.out.println(num1);

        int num = 50 ;
        num = num ++ * 2 ;
        System.out.println(num);

        int nu = 2147483647 ;
        nu += 2L ;
        System.out.println(nu) ;

        nu = 2147483647 ;
        long temp = nu + 2L ;
        System.out.println(nu) ;
    }
}
