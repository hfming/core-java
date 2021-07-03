package com.hfm.genericity;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-06-12 22:39
 * @Description 泛型接口及其实现类
 * @date 2021/6/12
 */

/**
 * 泛型接口
 *
 * @param <T>
 * @author hfm
 */
interface Dao<T> {
    void add(T t);
}

class DaoImpl<T> {
}

class BookDaoImpl<Book> extends DaoImpl<Book> {

}
class UserDaoImpl<User> extends DaoImpl<User> {

}

class UserDao3 implements Dao {
    @Override
    public void add(Object o) {
    }
}

class UserDao1<T> implements Dao<T> {
    @Override
    public void add(T t) {
    }
}

class UserDao2 implements Dao<String> {
    @Override
    public void add(String o) {
    }
}