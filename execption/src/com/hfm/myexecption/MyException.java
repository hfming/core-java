package com.hfm.myexecption;

/**
 * @author hfm
 * @version 1.01 2020-04-07 23:42
 * @date 2020/4/7
 */
public class MyException extends RuntimeException {
    static final long serialVersionUID = 13465653435L;
    private int idnumber;

    public MyException(String message, int id) {
        super(message);
        this.idnumber = id;
    }

    public int getId() {
        return idnumber;
    }
}
