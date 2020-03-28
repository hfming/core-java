package com.hfm.innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * 内部类
 *
 * @author Cay Horstmann
 * @version 1.10 2004-02-27
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock1 clock = new TalkingClock1(1000, true);
        clock.start();

        // 保持程序运行直到用户选择“确定”
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * 一个以固定时间间隔打印时间的时钟。
 */
class TalkingClock1 {
    private int interval;
    private boolean beep;


    /**
     * 构造函数
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public TalkingClock1(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    /**
     * 内部类
     */
    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
