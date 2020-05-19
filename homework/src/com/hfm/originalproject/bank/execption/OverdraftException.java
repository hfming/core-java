package com.hfm.originalproject.bank.execption;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 自定义异常类 透支异常警报
 * @date 2020-05-17 13:35
 */
public class OverdraftException extends RuntimeException {
    private String message;
    private double deficit;

    /**
     * 构造函数
     *
     * @param message
     */
    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
