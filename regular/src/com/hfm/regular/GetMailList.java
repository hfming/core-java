package com.hfm.regular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hfm
 * @version 1.01 2020/04/30
 * @date
 * @Description 正则表达式
 */
public class GetMailList {
    public static void main(String[] args) throws Exception {
        String reg = "\\w+@[a-zA-Z]+(\\.[a-zA-Z]+)+";
        getMailsByWeb(reg);
    }

    /**
     * 从互联网获取邮箱
     *
     * @param regex
     * @throws Exception
     */
    public static void getMailsByWeb(String regex) throws Exception {
        URL url = new URL("http://www.hao123.com/mail");
        URLConnection conn = url.openConnection();
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        Pattern p = Pattern.compile(regex);
        while ((line = bufIn.readLine()) != null) {
            // System.out.println(line);
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
        bufIn.close();
    }

    /**
     * 获取邮箱
     *
     * @param regex
     * @throws Exception
     */
    public static void getMails(String regex) throws Exception {
        BufferedReader bufr = new BufferedReader(new FileReader("mail.txt"));
        String line = null;
        Pattern p = Pattern.compile(regex);
        while ((line = bufr.readLine()) != null) {
            // System.out.println(line);
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
        bufr.close();
    }
}
