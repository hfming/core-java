package com.hfm.myexecption;

/**
 * @author hfm
 * @version 1.01 2020-04-07 23:42
 * @date 2020/4/7
 */
public class MyExecptionTest {
    public void regist(int num) throws MyException {
        if (num < 0) {
            throw new MyException("人数为负值，不合理", 3);
        } else {
            System.out.println("登记人数" + num);
        }
    }

    public void manager() {
        try {
            regist(100);
        } catch (MyException e) {
            System.out.print("登记失败，出错种类" + e.getId());
        }
        System.out.print("本次登记操作结束");
    }

    public static void main(String args[]) {
        MyExecptionTest t = new MyExecptionTest();
        t.manager();
    }
}
