package ru.vsu.dao;


import ru.vsu.entities.BaseEntity;
import ru.vsu.interfaces.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


/**
 * Created by Влад on 27.10.2016.
 * @param <TEntity>
 */
public abstract class AbstractDao<TKey, TEntity extends BaseEntity<TKey>> implements Dao<TKey, TEntity> {

    public AbstractDao(Class<TEntity> _class) {

        this._class = _class;
    }

    @PersistenceContext(name = "primary")
    protected EntityManager entityManager;
    protected Class<TEntity> _class;


    @Override
    public TEntity byId(TKey id) {

        return entityManager.find(_class, id);
    }

    @Override
    public void add(TEntity item) {

        entityManager.persist(item);
    }

    @Override
    public TEntity update(TEntity item) {

        return entityManager.merge(item);
    }

    @Override
    public void delete(TKey id){

        TEntity item = byId(id);

        entityManager.remove(item);
    }

    @Override
    public List<TEntity> getAll(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TEntity> cq = cb.createQuery(_class);

        CriteriaQuery<TEntity> all = cq.select(cq.from(_class));
        TypedQuery<TEntity> allQuery = entityManager.createQuery(all);

        return allQuery.getResultList();
    }

}
