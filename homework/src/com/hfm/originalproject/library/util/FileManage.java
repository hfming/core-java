package com.hfm.originalproject.library.util;

import com.hfm.originalproject.library.model.Book;
import com.hfm.originalproject.library.model.User;
import com.hfm.originalproject.library.myexecption.BookException;
import com.hfm.originalproject.library.myexecption.UserException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:44
 */
public class FileManage {
    private static File bookTxt = new File("project\\pic\\books");
    private static File userTxt = new File("project\\pic\\users");
    private static FileReader fileRead = null;
    private static FileWriter fileWriter = null;
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    /**
     * 文件读取
     */
    public static void fileRead(ArrayList<User> users, ArrayList<Book> books) {
        userRead(users);
        bookRead(books);
    }

    /**
     * user文件读取
     */
    private static void userRead(ArrayList<User> users) {
        try {
            fileRead = new FileReader(userTxt);
            bufferedReader = new BufferedReader(fileRead);
            String content = "";
            while ((content = bufferedReader.readLine()) != null) {
                String[] user = content.split("\\|");
                if (user.length == 4) {
                    users.add(new User(Integer.parseInt(user[0]), user[1], user[2], user[3]));
                } else if (user.length < 4) {
                    throw new UserException("用户信息异常！");
                } else {
                    ArrayList<Book> keepBook = new ArrayList<Book>();
                    String[] books = user[4].split("\\]");
                    String[] book = null;
                    for (int i = 0; i < books.length; i++) {
                        book = books[i].split(",");
                        if (book.length == 2) {
                            keepBook.add(
                                    new Book(Integer.parseInt(book[0].replace("[", "")), book[1].replace("]", "")));
                        } else if (book.length == 5) {
                            keepBook.add(new Book(Integer.parseInt(book[0].replace("[", "")), book[1],
                                    Double.parseDouble(book[2]), Integer.parseInt(book[3]), book[4].replace("]", "")));
                        } else {
                            throw new BookException("书籍信息异常");
                        }
                    }
                    users.add(new User(Integer.parseInt(user[0]), user[1], user[2], user[3], keepBook));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UserException e) {
            System.out.println("用户信息异常！");
            e.printStackTrace();
        } catch (BookException e) {
            System.out.println("书籍信息异常！");
            e.printStackTrace();
        } finally {
            try {
                fileRead.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            }
        }
    }

    /**
     * books文件读取
     *
     * @param books
     */
    private static void bookRead(ArrayList<Book> books) {
        try {
            fileRead = new FileReader(bookTxt);
            bufferedReader = new BufferedReader(fileRead);
            String content = "";
            while ((content = bufferedReader.readLine()) != null) {
                String[] book = content.split(",");
                if (book.length == 2) {
                    books.add(new Book(Integer.parseInt(book[0].replace("[", "")), book[1].replace("]", "")));
                } else if (book.length == 5) {
                    books.add(new Book(Integer.parseInt(book[0].replace("[", "")), book[1], Double.parseDouble(book[2]),
                            Integer.parseInt(book[3]), book[4].replace("]", "")));
                } else {
                    throw new BookException("书籍信息异常");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件读取失败！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BookException e) {
            System.out.println("用户信息异常！");
            e.printStackTrace();
        } finally {
            try {
                fileRead.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件写入
     */
    public static void fileWrite(ArrayList<User> users, ArrayList<Book> books) {
        userWrite(users);
        bookWrite(books);
    }

    /**
     * users文件写入
     */
    private static void userWrite(ArrayList<User> users) {
        try {
            fileWriter = new FileWriter(userTxt);
            bufferedWriter = new BufferedWriter(fileWriter);
            String content = "";
            Iterator<User> userIterator = users.iterator();
            User user = null;
            ArrayList<Book> keepBooks = null;
            Iterator<Book> keepBookIterator = null;
            String books = "";
            Book book = null;
            while (userIterator.hasNext()) {
                user = userIterator.next();
                keepBooks = user.getKeepBooks();
                if (keepBooks != null) {
                    keepBookIterator = keepBooks.iterator();
                    while (keepBookIterator.hasNext()) {
                        book = keepBookIterator.next();
                        books = books + "[" + book.getBookId() + "," + book.getBookName() + "," + book.getPrice() + ","
                                + book.getNumber() + "," + book.getAuthor() + "]";
                    }
                }
                bufferedWriter.write(user.getUserId() + "|" + user.getUserName() + "|" + user.getUserPassword() + "|"
                        + user.getMark() + "|" + books);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            }
        }
    }

    /**
     * books文件写入
     *
     * @param books
     */
    private static void bookWrite(ArrayList<Book> books) {
        try {
            fileWriter = new FileWriter(bookTxt);
            bufferedWriter = new BufferedWriter(fileWriter);
            String content = "";
            Iterator<Book> iterator = books.iterator();
            Book book = null;
            while (iterator.hasNext()) {
                book = iterator.next();
                //System.out.println(book.toString());
                bufferedWriter.write("[" + book.getBookId() + "," + book.getBookName() + "," + book.getPrice() + ","
                        + book.getNumber() + "," + book.getAuthor() + "]");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("文件关闭失败！");
                e.printStackTrace();
            }
        }
    }
}