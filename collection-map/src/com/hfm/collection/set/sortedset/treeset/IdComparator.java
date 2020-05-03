package com.hfm.collection.set.sortedset.treeset;

import com.hfm.entity.People;

import java.util.Comparator;

/**
 * 自定义比较器
 *
 * @author hfm
 */
public class IdComparator implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        return Integer.parseInt(o1.getId()) - Integer.parseInt(o2.getId());
    }
}
