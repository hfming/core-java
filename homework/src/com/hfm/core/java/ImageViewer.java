package com.hfm.core.java;

// 静态导入
import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * 用于查看图像的程序。
 * 
 * @version 1.31 2018-04-10
 * @author Cay Horstmann
 */
public class ImageViewer {
    public static void main(String[] args) {
        // lambda 表达式 
        /*  EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });*/
        // 内部内形式，创建匿名内部内，并启动线程
        /* EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ImageViewerFrame();
                frame.setTitle("ImageViewer");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });*/
        /// JDK更高版本(Java 10)支持var局部变量自动判断数据类型形式的拉姆達表達式
          EventQueue.invokeLater(() -> {
            // var 字面量
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}