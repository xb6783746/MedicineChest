package ru.vsu.dao;


import ru.vsu.entities.MedicamentEntity;
import ru.vsu.interfaces.MedicamentDao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Created by Влад on 27.10.2016.
 */

@Stateless
public class MedicamentDaoImpl extends AbstractDao<Long, MedicamentEntity> implements MedicamentDao{


    public MedicamentDaoImpl() {
        super(MedicamentEntity.class);

    }

    @Override
    public MedicamentEntity byName(String name){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MedicamentEntity> cq = cb.createQuery(_class);

        Root<MedicamentEntity> root = cq.from(_class);

        CriteriaQuery<MedicamentEntity> cr = cq
                .select(root)
                .where(cb.equal(root.get("name"), name));

        TypedQuery<MedicamentEntity> res = entityManager.createQuery(cr);

        return res.getSingleResult();
    }

}
