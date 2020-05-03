package com.hfm.myexecption;

/**
 * @author hfm
 * @version 1.01 2020-04-02 20:07
 * @date 2020/4/2
 */
public class RegisterException extends RuntimeException {
    /**
     *  空参构造
     */
    public RegisterException() {
    }

    /**
     * @param message 表示异常提示      
     */
    public RegisterException(String message) {
        super(message);
    }
}

