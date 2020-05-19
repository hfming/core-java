package com.hfm.comunication;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-05-08 15:03
 */
public class WithDrawThread extends Thread {
    Account account;
    /**
     * 要取款的额度
     */
    double withDraw;

    public WithDrawThread(String name, Account account, double amt) {
        super(name);
        this.account = account;
        this.withDraw = amt;
    }

    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() > withDraw) {
                System.out.println(Thread.currentThread().getName() + ":取款成功，取现的金额为：" + withDraw);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - withDraw);
            } else {
                System.out.println("取现额度超过账户余额，取款失败");
            }
            System.out.println("现在账户的余额为：" + account.getBalance());
        }
    }
}
