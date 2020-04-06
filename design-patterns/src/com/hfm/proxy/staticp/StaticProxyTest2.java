package com.hfm.proxy.staticp;

/**
 * @author hfm
 * @version 1.01 2020-04-04 12:20
 * @date 2020/4/4
 */
public class StaticProxyTest2 {
    public static void main(String[] args) {
        Star s = new Proxy(new RealStar());
        s.confer();
        s.signContract();
        s.bookTicket();
        s.sing();
        s.collectMoney();
    }
}

/**
 * 接口
 */
interface Star {
    void confer();// 面谈

    void signContract();// 签合同

    void bookTicket();// 订票

    void sing();// 唱歌

    void collectMoney();// 收钱
}

/**
 * 实现类
 */
class RealStar implements Star {

    @Override
    public void confer() {
    }

    @Override
    public void signContract() {
    }

    @Override
    public void bookTicket() {
    }

    @Override
    public void sing() {
        System.out.println("明星：歌唱~~~");
    }

    @Override
    public void collectMoney() {
    }
}

/**
 * 代理类
 */
class Proxy implements Star {
    private Star real;

    public Proxy(Star real) {
        this.real = real;
    }

    @Override
    public void confer() {
        System.out.println("经纪人面谈");
    }

    @Override
    public void signContract() {
        System.out.println("经纪人签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("经纪人订票");
    }

    @Override
    public void sing() {
        real.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}
