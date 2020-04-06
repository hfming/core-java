package com.hfm.execption;

        import java.io.Serializable;

/**
 * 自定义异常类
 *
 * @author hfm
 */
public class NoMoneyException extends Exception implements Serializable {
    private static final long serialVersionUID = 9071857680365873880L;

    /**
     * 自定义异常方法
     *
     * @param message
     */
    public NoMoneyException(String message) {
        super(message);
    }
}
