package com.hfm.project.teammanage.entity;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description 人员状态枚举类
 * @date 2020-04-18 11:40
 */
public enum Status {
    /**
     * 空闲
     */
    FREE("空闲"),
    /**
     * 已加入开发团队
     */
    BUSY("已加入开发团队"),
    /**
     * 正在休假
     */
    VOCATION("正在休假");
    private String status;

    /**
     * 构造函数
     */
    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
