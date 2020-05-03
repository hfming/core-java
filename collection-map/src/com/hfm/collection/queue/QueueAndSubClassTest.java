package com.hfm.collection.queue;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class QueueAndSubClassTest {
    public static void main(String[] args) {
        Queue queue = new Queue() {
            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public Object remove() {
                return null;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object element() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] objects) {
                return new Object[0];
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection collection) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        AbstractQueue abstractQueue = new AbstractQueue() {
            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean offer(Object o) {
                return false;
            }

            @Override
            public Object poll() {
                return null;
            }

            @Override
            public Object peek() {
                return null;
            }
        };
    }
}
