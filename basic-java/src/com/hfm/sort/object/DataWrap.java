package com.hfm.sort.object;

/**
 * @author hfm
 */
public class DataWrap implements Comparable<DataWrap> {
    int data;
    String flag;

    public DataWrap(int data, String flag) {
        this.data = data;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return data + flag;
    }

    /**
     * 根据data实例变量来决定两个dataWrap的大小
     *
     * @param dw
     * @return
     */
    @Override
    public int compareTo(DataWrap dw) {
        return this.data > dw.data ? 1 : (this.data == dw.data ? 0 : -1);
    }
}
