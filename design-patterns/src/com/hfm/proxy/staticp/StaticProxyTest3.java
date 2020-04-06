package com.hfm.proxy.staticp;

/**
 * 代理测试
 *
 * @author hfm
 * @version 1.01 2020-04-04 17:25
 * @date 2020/4/4
 */
public class StaticProxyTest3 {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像将无法从磁盘加载
        image.display();
    }
}

/**
 * 接口
 */
interface Image {
    void display();
}

/**
 * 实现类
 */
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }
}

/**
 * 代理类
 */
class ProxyImage implements Image {
    /**
     * 代理类内部维护了一个被代理类对象，通过构造器对其进行初始化赋值
     */
    private RealImage realImage;
    private String fileName;

    /**
     * 构造器对其进行初始化赋值
     * 具体的都是在代理类中注入委托类，然后调用委托类的对应方法
     *
     * @param fileName
     */
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 重写该方法，以便堆被代理类的方法进行扩展
     */
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}