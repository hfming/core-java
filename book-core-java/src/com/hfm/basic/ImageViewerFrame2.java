package com.hfm.basic;

import javax.swing.*;
import java.io.File;

/**
 * 带有标签的框架，用于显示图像。
 * Java 10编译
 *
 * @author hfm
 * @version 1.01 2019-09-19
 */
public class ImageViewerFrame2 extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame2() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 使用标签显示图像
        // Java 10 var 局部变量参数类型自动判断
        var label = new JLabel();
        add(label);

        // 设置文件选择器
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // 设置菜单栏
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // 设置菜单条
        var menu = new JMenu("File");
        menuBar.add(menu);

        // 设置菜单项
        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            // 显示文件选择器对话框
            int result = chooser.showOpenDialog(null);
            // 如果选择了文件，请将其设置为标签的图标
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        var exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        // 设置单击响应
        exitItem.addActionListener(event -> System.exit(0));
    }
}
