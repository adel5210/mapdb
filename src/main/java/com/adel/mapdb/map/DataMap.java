package com.adel.mapdb.map;

/**
 * @author Adel.Albediwy
 */
public interface DataMap <K,V>{
    void put(K key, V value);

    V get(K key);

    void close();
}
