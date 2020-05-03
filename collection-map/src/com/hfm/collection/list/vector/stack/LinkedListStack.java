package com.hfm.collection.list.vector.stack;

import java.util.LinkedList;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-19 21:45
 */
public class LinkedListStack extends LinkedList {
    public LinkedListStack(){
        super();
    }
    @Override
    public void push(Object o) {
        super.push(o);
    }
    @Override
    public Object pop() {
        return super.pop();
    }
    @Override
    public Object peek() {
        return super.peek();
    }
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    public int search(Object o){
        return indexOf(o);
    }
}
