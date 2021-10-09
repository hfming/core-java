package com.hfm.create;

import java.util.concurrent.Callable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-09 16:49
 */
public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    /**
     * Computes a result, or throws an exception
     * * @throws Exception if unable to compute a result if unable to do so.
     *
     * @return computed result
     */
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                sum += i;
            }
        }
        return sum;
    }
}
