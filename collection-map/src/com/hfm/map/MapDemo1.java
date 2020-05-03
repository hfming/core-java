package com.hfm.map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 计算一个字符串中每个字符出现次数。
 * 1. 获取一个字符串对象
 * 2. 创建一个Map集合，键代表字符，值代表次数。
 * 3. 遍历字符串得到每个字符。
 * 4. 判断Map中是否有该键。
 * 5. 如果没有，第一次出现，存储次数为1；如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
 * 6. 打印最终结果
 * @date 2020-04-24 15:42
 */
public class MapDemo1 {
    public static void main(String[] args) {
        //友情提示
        System.out.println("请录入一个字符串:");
        String line = new Scanner(System.in).nextLine();
        // 定义 每个字符出现次数的方法
        findChar(line);
    }

    private static void findChar(String line) {
        //1:创建一个集合 存储  字符 以及其出现的次数
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //2:遍历字符串
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            //判断 该字符 是否在键集中
            //说明这个字符没有出现过
            if (!map.containsKey(c)) {
                //那就是第一次
                map.put(c, 1);
            } else {
                //先获取之前的次数
                Integer count = map.get(c);
                //count++;
                //再次存入  更新
                map.put(c, ++count);
            }
        }
        System.out.println(map);
    }
}