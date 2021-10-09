package com.hfm.protectivemode;

import java.util.Hashtable;
import java.util.Set;

/**
 * @author hfming2016@163.com
 * @version 1.01 2021-09-14 17:19
 * @Description
 * @date 2021/9/14
 */
public class Futures {
    /**
     * 用于存储 GuardedObject
     */
    private static volatile Hashtable<Integer, GuardedObjectId> guardedObjects = new Hashtable<>();
    /**
     * 用于标记 GuardedObject 编号
     */
    private static volatile int id = 0;

    /**
     * id 自增
     *
     * @return
     */
    public synchronized static int getId() {
        return id++;
    }

    /**
     * 生产保护者
     *
     * @return
     */
    public static GuardedObjectId createGuardedObjectId() {
        GuardedObjectId guardedObjectId = new GuardedObjectId(getId());
        // 将保护者放入集合中
        guardedObjects.put(guardedObjectId.getId(), guardedObjectId);
        return guardedObjectId;
    }

    /**
     * 获取 id 集合
     * @return
     */
    public static Set<Integer> getIds() {
        return guardedObjects.keySet();
    }

    /**
     * 通过 id 获取保护者
     * @param id
     * @return
     */
    public static GuardedObjectId getGuardedObjectById(int id) {
        return guardedObjects.remove(id);
    }
}
