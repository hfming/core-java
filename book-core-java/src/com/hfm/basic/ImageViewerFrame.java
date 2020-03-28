package com.hfm.basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 带有标签的框架，用于显示图像。
 *
 * @author hfm
 */
public class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // 使用标签显示图像
        JLabel label = new JLabel();
        // var label = new JLabel();
        add(label);

        // 设置文件选择器
        JFileChooser chooser = new JFileChooser();
        //  var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        // 设置菜单栏
        JMenuBar menuBar = new JMenuBar();
        // var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // 设置菜单条
        JMenu menu = new JMenu("File");
        // var menu = new JMenu("File");
        menuBar.add(menu);

        // 设置菜单项
        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // 显示文件选择器对话框
                int result = chooser.showOpenDialog(null);

                // 如果选择了文件，请将其设置为标签的图标
                if (result == JFileChooser.APPROVE_OPTION) {
                    String name = chooser.getSelectedFile().getPath();
                    label.setIcon(new ImageIcon(name));
                }
            }
        });

        // lambda 表达式 设置监听器
        /*  openItem.addActionListener(event -> {
            // 显示文件选择器对话框
            int result = chooser.showOpenDialog(null);
            // 如果选择了文件，请将其设置为标签的图标
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });*/

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        // 设置单击响应
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        // lambda 表达式
        //exitItem.addActionListener(event -> System.exit(0));
    }
}
