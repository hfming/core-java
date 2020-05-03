package com.hfm.map.sortedmap;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * @author hfm Email:hfming2016@163.com
 * @version v 1.01
 * @Description
 * @date 2020-04-25 17:23
 */
public class SortedMapTest {
    @Test
    public void sortedMap(){
        SortedMap sortedMap = new SortedMap() {
            @Override
            public Comparator comparator() {
                return null;
            }

            @Override
            public SortedMap subMap(Object o, Object k1) {
                return null;
            }

            @Override
            public SortedMap headMap(Object o) {
                return null;
            }

            @Override
            public SortedMap tailMap(Object o) {
                return null;
            }

            @Override
            public Object firstKey() {
                return null;
            }

            @Override
            public Object lastKey() {
                return null;
            }

            @Override
            public Set keySet() {
                return null;
            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
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
            public boolean containsKey(Object o) {
                return false;
            }

            @Override
            public boolean containsValue(Object o) {
                return false;
            }

            @Override
            public Object get(Object o) {
                return null;
            }

            @Override
            public Object put(Object o, Object o2) {
                return null;
            }

            @Override
            public Object remove(Object o) {
                return null;
            }

            @Override
            public void putAll(Map map) {

            }

            @Override
            public void clear() {

            }
        };
    }
}
