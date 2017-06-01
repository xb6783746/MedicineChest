package ru.vsu.interfaces;

import ru.vsu.entities.BaseEntity;

import java.util.List;

/**
 * Created by Влад on 01.06.2017.
 */
public interface Dao<TKey, TEntity extends BaseEntity<TKey>> {

    TEntity byId(TKey id);
    void add(TEntity entity);
    TEntity update(TEntity entity);
    void delete(TKey id);
    List<TEntity> getAll();
}
