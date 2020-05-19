package com.hfm.originalproject.library.myexecption;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:46
 */
public class UserException extends Exception {
    private static final long serialVersionUID = -8077363780170987957L;

    public UserException(String exception) {
        super(exception);
    }
}
