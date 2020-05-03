package com.hfm.teammanage.myexception;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 自定义异常类 EmployeeNoFoundException 没有找到员工
 * @date 2020-04-18 12:04
 */
public class EmployeeNoFoundException  extends EmployeeException implements Serializable {
    private static final long serialVersionUID = -1291333183927039166L;

    /**
     * @param message 返回异常信息
     */
    public EmployeeNoFoundException(String message) {
        super(message);
    }
}
