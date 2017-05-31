package ru.vsu.entities;

/**
 * Created by Влад on 21.02.2017.
 */
public abstract class BaseEntity<TKey> {

    public abstract TKey getId();
    public abstract void setId(TKey key);
}
