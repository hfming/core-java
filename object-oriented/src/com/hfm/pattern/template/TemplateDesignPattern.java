package com.hfm.pattern.template;

/**
 * 模板设计模式
 *
 * @author hfm
 */
public abstract class TemplateDesignPattern {
    /**
     * 模板类中不变的步骤，使用final修饰防止子类重写该方法
     */
    public final void getRunTime() {
        // 代码运行之前记录当前的系统时间
        long startTime = System.currentTimeMillis();
        code();
        // 代码运行后的时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序的运行时间：" + (endTime - startTime));
    }

    /**
     * 抽象方法，是模板类中会发生变化的步骤
     */
    public abstract void code();
}
