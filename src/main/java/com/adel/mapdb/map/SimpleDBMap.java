package com.adel.mapdb.map;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

/**
 * @author Adel.Albediwy
 */
public class SimpleDBMap<K,V> implements DataMap<K, V> {

    private final DB db;
    private final HTreeMap map;

    public SimpleDBMap() {
//        db = DBMaker.memoryDirectDB().make();
        db = DBMaker.fileDB("simple.db").make();
        map = db.hashMap("myMap").createOrOpen();
    }

    @Override
    public void put(final K key, final V value) {
        map.put(key, value);
    }

    @Override
    public V get(final K key) {
        return (V) map.get(key);
    }

    @Override
    public void close() {
        map.close();
    }
}
