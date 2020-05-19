package com.hfm.properties;

import java.io.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Properties properties = new Properties();
        // setProperty() 配置键值对
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");
        properties.setProperty("key4", "value4");

        System.out.println(properties.toString());
        // 遍历集合
        Set<Entry<Object, Object>> set = properties.entrySet();
        Iterator<Entry<Object, Object>> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        checkRuntime();
        // createProperties();
        loginProperties();
        loginProperties2();
    }

    /**
     * 需求：使用 porperites 文件实现本软件只能试用三次，三次之后提示用户购买正版，退出 jvm。
     */
    public static void checkRuntime() throws IOException, FileNotFoundException {
        // 先检查是否存在配置文件
        File file = new File("D:\\Code\\core-java-simple\\file-io\\src\\com\\hfm\\properties\\runtime.properties");
        // 如果不存在，创建配置文件
        if (!file.exists()) {
            file.createNewFile();
        }
        // 创建一个 Properties 对象
        Properties properties = new Properties();
        // load 方法，加载配置文件
        properties.load(new FileReader(file));
        // 定义一个变量记录运行的次数
        int count = 0;
        // 如果配置文件记录了运行次数，则应该使用配置文件的运行次数
        // getProperty 获取 values
        String num = properties.getProperty("num");
        if (num != null) {
            count = Integer.parseInt(num);
        }
        // 判断是否已经运行了三次
        if (count == 3) {
            System.out.println("已经到了使用次数，请购买正版！！88");
            System.exit(0);
        }
        count++;
        properties.setProperty("num", count + "");
        System.out.println("你已经运行了" + count + "次，还剩余" + (3 - count) + "次");
        // store方法，重新生成配置文件
        properties.store(new FileWriter(file), "runtime");
    }

    /**
     * 生产配置文件
     */
    public static void createProperties() {
        File file = new File("D:\\Code\\core-java-simple\\file-io\\src\\com\\hfm\\properties\\properties.properties");
        Properties properties = new Properties();
        properties.setProperty("key1", "value1");
        properties.setProperty("key2", "value2");
        properties.setProperty("key3", "value3");
        properties.setProperty("key4", "value4");
        try (
                FileWriter fileWriter = new FileWriter(file);
        ) {
            properties.store(fileWriter, "配置文件");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 配置文件如果有中文需要使用字符流进行文件读取 读取配置文件
     *
     * @param
     */
    public static void loginProperties() {
        File file = new File("D:\\Code\\core-java-simple\\file-io\\src\\com\\hfm\\properties\\properties.properties");
        Properties properties = new Properties();
        try (
                FileReader fileReader = new FileReader(file);
        ) {
            // 加载配置文件
            properties.load(fileReader);
            // 遍历集合
            Set<Entry<Object, Object>> set = properties.entrySet();
            Iterator<Entry<Object, Object>> iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 字节流读取配置文件也没有问题
     *
     * @param
     */
    public static void loginProperties2() {
        File file = new File("D:\\Code\\core-java-simple\\file-io\\src\\com\\hfm\\properties\\properties.properties");
        Properties properties = new Properties();
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
        ) {
            // 加载配置文件
            properties.load(fileInputStream);
            // 遍历集合
            Set<Entry<Object, Object>> set = properties.entrySet();
            Iterator<Entry<Object, Object>> iterator = set.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
