package com.hfm.project.exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-17 14:30
 */
public class ItemService {
    private List<Item> items = new ArrayList<>(100);

    public ItemService(String fileName) {
        readTextFile(fileName);
    }

    /**
     * 读取文件数据，将文件转化为对象
     *
     * @param filename
     */
    private void readTextFile(String filename) {
        String content = null;
        String itemName = null;
        String[] options = new String[4];
        String answer = null;
        try (
                FileReader fileRead = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileRead)
        ) {
            int count = 0;
            while ((content = bufferedReader.readLine()) != null) {
                ++count;
                // JDK 7 开始支持 String 与 enum 数据类型
                // JDK 12 开始Switch 可以使用 -> 符号，可以省略 break
                // JDK 13 开始switch 可以使用 yield 关键字，也可以省略 break
                switch (count) {
                    case 1:
                        itemName = content;
                        break;
                    case 2:
                        options[0] = content;
                        break;
                    case 3:
                        options[1] = content;
                        break;
                    case 4:
                        options[2] = content;
                        break;
                    case 5:
                        options[3] = content;
                        break;
                    case 6:
                        answer = content;
                        break;
                    case 7:
                        Item item = new Item(itemName, options, answer);
                        // ?
                        options = new String[4];
                        items.add(item);
                        count = 0;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * 根据 题目编号获取题目
     *
     * @param id
     * @return
     */
    public Item getItemByID(int id) {
        return this.items.get(id - 1);
    }

    /**
     * 该方法创建 answer.dat 二进制文件，并将数组中的内容以对象形式写入到文件中保存
     *
     * @param answer
     */
    public void saveAnswer(char[] answer) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("homework/Resources/answer.dat");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            objectOutputStream.writeObject(answer);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readAnswer() {
        try (
                FileInputStream fileInputStream = new FileInputStream("homework/Resources/answer.dat");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            char[] answers = (char[]) objectInputStream.readObject();
            System.out.print("你上次的答案是：");
            for (char c : answers) {
                System.out.print(c + "\t");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
