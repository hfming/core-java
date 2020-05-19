package com.hfm.project.exam;

import java.util.Scanner;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-17 15:10
 */
public class ExamView {
    private Scanner scanner = new Scanner(System.in);
    private char[] answers;
    private ItemService itemService = new ItemService("homework/Resources/Items.txt");

    public char getUserAction() {
        String next = scanner.next();
        char asnwer;
        switch (next) {
            case "a":
                asnwer = 'a';
                break;
            case "A":
                asnwer = 'a';
                break;
            case "b":
                asnwer = 'b';
                break;
            case "B":
                asnwer = 'b';
                break;
            case "c":
                asnwer = 'c';
                break;
            case "C":
                asnwer = 'c';
                break;
            case "d":
                asnwer = 'd';
                break;
            case "D":
                asnwer = 'd';
                break;
            case "n":
                asnwer = 'n';
                break;
            case "N":
                asnwer = 'n';
                break;
            case "p":
                asnwer = 'p';
                break;
            case "P":
                asnwer = 'p';
                break;
            default:
                System.out.println("输入错误选项，跳过本题，进入下一题！");
                asnwer = 'n';
        }
        return asnwer;
    }

    /**
     * 该方法显示参数no指定的考题内容，不含答案
     *
     * @param no
     */
    public void displayItem(int no) {
        Item itemByID = itemService.getItemByID(no);
        System.out.println(itemByID.getItemName());
        String[] options = itemByID.getOptions();
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void testExam() {
        // 初始化答案数组
        this.answers = new char[itemService.getItems().size()];
        displayItem(1);
        int num = 1;
        OUT:
        while (true) {
            char answer = getUserAction();
            this.answers[num - 1] = answer;
            switch (answer) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                    System.out.println("正确答案：" + itemService.getItemByID(num).getAnswer());
                case 'n':
                    if (num == itemService.getItems().size()) {
                        // this.answers = new char[itemService.getItems().size()];
                        System.out.print("你的答案是：");
                        for (char c : answers) {
                            System.out.print(c + "\t");
                        }
                        System.out.println();
                        System.out.print("正确答案是：");
                        for (Item item : itemService.getItems()) {
                            System.out.print(item.getAnswer() + "\t");
                        }
                        System.out.println();

                        System.out.println("保存试卷！");
                        itemService.saveAnswer(answers);
                        break OUT;
                    }
                    displayItem(num + 1);
                    num++;
                    break;
                case 'p':
                    if (num == 1) {
                        displayItem(1);
                    } else {
                        displayItem(num - 1);
                        num--;
                    }
                    break;
            }
        }
    }
}
