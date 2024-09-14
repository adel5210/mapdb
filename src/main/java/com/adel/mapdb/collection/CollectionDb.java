package com.adel.mapdb.collection;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.serializer.SerializerByte;

import java.util.NavigableSet;

/**
 * @author Adel.Albediwy
 */
public class CollectionDb implements DataCollect {
    private final DB db;
    private final NavigableSet<String> set;

    public CollectionDb() {
        this.db = DBMaker.fileDB("collection.db").make();

        set = db.treeSet("collection")
                .serializer(SerializerByte.STRING)
                .createOrOpen();
    }

    @Override
    public void add(final String item) {
        set.add(item);
    }

    @Override
    public void remove(final String item) {
        set.remove(item);
    }
}
