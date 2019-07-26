package com.jayqqaa12.design;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LRU
 * LRU cache的数据结构，实现set和get功能。学习过操作系统的都应该知道，
 * cache作为缓存可以帮助快速存取数据，但是确定是容量较小。这道题要求实现的cache类型是LRU，
 * LRU的基本思想就是“最近用到的数据被重用的概率比较早用到的大的多”，是一种更加高效的cache类型。
 * 难度3星
 * <p>
 * 使用linkedHashMap 自带了lRU
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {//最年长的
        return size() > capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        put(key, value);
    }
}