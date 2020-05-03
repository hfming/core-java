package com.hfm.teammanage.myexception;

        import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-18 18:19
 */
public class EmployeeException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 2146802106167036737L;

    /**
     * @param message 返回异常信息
     */
    public EmployeeException(String message) {
        super(message);
    }
}
