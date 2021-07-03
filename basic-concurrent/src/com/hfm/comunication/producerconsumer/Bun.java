package com.hfm.comunication.producerconsumer;

import java.io.Serializable;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 面包类
 * @date 2020-05-07 11:30
 */
public class Bun implements Serializable {
    private static final long serialVersionUID = 8737790916547267819L;

    private String pier;
    private String xianer;
    /**
     * 包子资源 是否存在  包子资源状态
     */
    private boolean flag = false;

    public Bun() {
    }

    public Bun(String pier, String xianer, boolean flag) {
        this.pier = pier;
        this.xianer = xianer;
        this.flag = flag;
    }

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
        this.pier = pier;
    }

    public String getXianer() {
        return xianer;
    }

    public void setXianer(String xianer) {
        this.xianer = xianer;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
