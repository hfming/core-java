package com.hfm.myexecption;

import javax.security.auth.login.LoginException;

/**
 * @author hfm
 * @version 1.01 2020-04-02 20:09
 * @date 2020/4/2
 */
public class RegisterExceptionTest {
    /**
     * 模拟数据库中已存在账号
     */
    private static String[] names = {"bill" , "hill" , "jill"};

    public static void main(String[] args) {
        //调用方法
        try {
            // 可能出现异常的代码
            checkUsername("bill");
            //如果没有异常就是注册成功
            System.out.println("注册成功");
        } catch (RegisterException | LoginException e) {
            //处理异常
            e.printStackTrace();
        }
    }

    /**
     * 判断当前注册账号是否存在
     * 因为是编译期异常，又想调用者去处理 所以声明该异常
     */
    public static boolean checkUsername(String uname) throws LoginException {
        for (String name : names) {
            //如果名字在这里面 就抛出登陆异常
            if (name.equals(uname)) {
                throw new RegisterException("亲" + name + "已经被注册了！");
            }
        }
        return true;
    }
}
