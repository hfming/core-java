package com.hfm.library.service;

import com.hfm.library.model.User;

import java.util.Comparator;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 0:47
 */
public class IdComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getUserId() - o2.getUserId();
    }
}
