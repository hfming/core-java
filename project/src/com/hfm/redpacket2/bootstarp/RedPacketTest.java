package com.hfm.redpacket2.bootstarp;

import com.hfm.redpacket2.impl.Common;
import com.hfm.redpacket2.windows.RedPacket;

/**
 * 红包文化源远流长。从古时的红色纸包，到手机App中的手气红包，红包作为一种独特的中华文化传承至今。之前的课程中，我们也编写过程序，模拟发普通红包。那么今天，我们将整合基础班课程中所有的技术和知识，编写一个带界面版的 发红包 案例。
 * 目前，我们尚未学习过任何与界面相关的类。所以，界面相关代码，已经给出。请运用所学技术分析并使用。
 * 分析并使用已给出的类，编写程序，设置红包类型。
 * 红包类型：
 * 1. 普通红包：金额均分。不能整除的，余额添加到最后一份红包中。
 * 2. 手气红包：金额随机。各个红包金额累和与总金额相等。
 * 此案例是模拟群主给群成员发红包，群主自己打开最后一个红包的场景。
 *
 * @author hfm
 * @version 1.01 2020-04-02 17:23
 * @date 2020/4/2
 */
public class RedPacketTest {
    public static void main(String[] args) {
        // 创建红包对象
        RedPacket rp = new RedPacket("大红包");
        // 设置群主名称
        rp.setOwnerName("我是群大大");

        // 设置红包类型 普通红包
        rp.setOpenWay(new Common());
        /**
         * 通过 发红包 案例，你都学到了什么呢？请你思考如下问题：
         * 1. 基础语法，你是否清晰？
         * 2. 一些基本的类的方法，你是否能够调用？
         * 3. 案例中哪里体现了继承，继承的作用是什么？
         * 4. 接口作为参数，如何使用？
         * 5. 接口作为成员变量，如何使用？
         * 6. 如何简化接口的使用方式？
         */
    }
}
