package com.hfm.teammanage.myexception;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-18 18:21
 */
public class EmployeeAddException extends EmployeeException implements Serializable {

    private static final long serialVersionUID = -4688375144827958413L;

    /**
     * @param message 返回异常信息
     */
    public EmployeeAddException(String message) {
        super(message);
    }
}
