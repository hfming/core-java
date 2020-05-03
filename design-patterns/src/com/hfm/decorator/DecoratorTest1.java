package com.hfm.decorator;

import java.io.*;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-02 10:40
 */
public class DecoratorTest1 {
    public static void main(String[] args) {
        File file = new File("file-io\\Resources\\CharacterStream_4.txt");
        String lineContext = null;
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedReaderNum bufferedReaderNum = new BufferedReaderNum(bufferedReader);
                BufferedReaderSemi bufferedReaderSemi = new BufferedReaderSemi(bufferedReader);
        ) {
            // 没有继承 BufferedReader 不能关闭
            BufferedReaderNum1 bufferedReaderNum1 = new BufferedReaderNum1(bufferedReader);
            // 没有继承 BufferedReader，内部只有readLine方法，无法调用 close方法
            while ((lineContext = bufferedReaderNum1.readLine()) != null) {
                System.out.println(lineContext);
            }

            // 继承 BufferedReader，仅仅重写 readLine方法，可以调用 close方法，推荐使用这种方式实现装饰者设计模式
            while ((lineContext = bufferedReaderNum.readLine()) != null) {
                System.out.println(lineContext);
            }

            // 继承 BufferedReader，仅仅重写 readLine方法，可以调用 close方法，推荐使用这种方式实现装饰者设计模式
            while ((lineContext = bufferedReaderSemi.readLine()) != null) {
                System.out.println(lineContext);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
