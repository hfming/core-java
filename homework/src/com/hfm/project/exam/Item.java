package com.hfm.project.exam;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 题目实体类
 * @date 2020-05-17 14:36
 */
public class Item {
    /**
     * 题目名
     */
    private String itemName;
    /**
     * 4个选项
     */
    private String[] options;

    /**
     * 答案
     */
    private String answer;

    /**
     * 构造函数
     *
     * @param itemName
     * @param options
     * @param answer
     */
    public Item(String itemName, String[] options, String answer) {
        this.itemName = itemName;
        this.options = options;
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(getItemName(), item.getItemName()) &&
                Arrays.equals(getOptions(), item.getOptions()) &&
                Objects.equals(getAnswer(), item.getAnswer());
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getItemName(), getAnswer());
        result = 31 * result + Arrays.hashCode(getOptions());
        return result;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
