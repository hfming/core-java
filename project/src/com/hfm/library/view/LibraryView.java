package com.hfm.library.view;

import com.hfm.library.dao.RootUserDao;
import com.hfm.library.dao.UserDao;
import com.hfm.library.model.Book;
import com.hfm.library.model.User;
import com.hfm.library.util.FileManage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:55
 */
public class LibraryView {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Book> books = new ArrayList<Book>();
    private static RootUserDao rootUserDao = new RootUserDao(users);
    private static UserDao userDao = new UserDao();

    public static void main(String[] args) {
        // welcome();
        // 加载users与books文件
        FileManage.fileRead(users, books);
        while (true) {
            System.out.println("==============================================");
            System.out.println("=                                            =");
            System.out.println("= 请选择功能 A：登录 B：注册 C:退出            =");
            System.out.println("=                                            =");
            System.out.println("==============================================");
            String choice = scanner.next();
            if ("A".equalsIgnoreCase(choice)) {
                System.out.println("请输入用户账号及密码");
                System.out.println("账号：");
                String userName = scanner.next();
                System.out.println("密码：");
                String userPassword = scanner.next();
                //应该取集合中的姓名与密码进行判断，如果存在则取出对象
                User user = users.get(0);
                if (users.contains(user)) {
                    welcome();
                    while (true) {
                        System.out.println("==============================================");
                        System.out.println("=                                            =");
                        System.out.println("=请选择功能A：借书 B：找书 C:还书 D:改变信息 E:打印信息 F:退出=");
                        System.out.println("=                                            =");
                        System.out.println("==============================================");
                        choice = scanner.next();
                        if ("A".equalsIgnoreCase(choice)) {
                            //打印所有的书，让用户选择书籍
                            //System.out.println(books.toString());
                            //System.out.println(books.get(0).toString());
                            userDao.brrorwBook(books, books.get(0), user);
                        } else if ("B".equalsIgnoreCase(choice)) {
                            //让用户输入书名等关键字信息，然后进行判断的操作

                            userDao.findBook(books, books.get(0));
                        } else if ("C".equalsIgnoreCase(choice)) {
                            //先判断用户是否有书，然后打印用户的书，让用户之间选择要还的书

                            userDao.returnBook(books, user.getKeepBooks().get(0), user);
                        } else if ("D".equalsIgnoreCase(choice)) {
                            userDao.changeUser(users, user);
                        } else if ("E".equalsIgnoreCase(choice)) {
                            userDao.showUser(users, user);
                        } else if ("F".equalsIgnoreCase(choice)) {
                            break;
                        } else {
                            System.out.println("=               选择错误，请重新选择                               =");
                        }
                    }
                } else {
                    System.out.println("账号或密码输入错误请重新登陆！");
                }
            } else if ("B".equalsIgnoreCase(choice)) {
                System.out.println("账号：");
                String userName = scanner.next();
                System.out.println("密码：");
                String userPassword = scanner.next();
                User user = new User(userName, userPassword);
                if (users.contains(user)) {
                    System.out.println("已经存在该用户，请直接登陆!");
                } else {
                    //将用户加入到用户组中
                    userDao.addUser(users, user);
                    System.out.println("现在你可以登陆图书馆了！");
                }
            } else if ("C".equalsIgnoreCase(choice)) {
                FileManage.fileWrite(users, books);
                break;
            } else {
                System.out.println("=               选择错误，请重新选择                               =");
            }
        }
        FileManage.fileWrite(users, books);
        goodBye();
    }

    /**
     * 再见
     */
    private static void goodBye() {
        System.out.println("==============================================");
        System.out.println("=                                            =");
        System.out.println("=      再见,期待你再次使用本程序!              =");
        System.out.println("=                                            =");
        System.out.println("==============================================");
    }

    /**
     * 欢迎界面
     */
    private static void welcome() {
        System.out.println("==============================================");
        System.out.println("=                                            =");
        System.out.println("=            欢迎进入CJLU图书馆               =");
        System.out.println("=                                            =");
        System.out.println("==============================================");
    }

}
