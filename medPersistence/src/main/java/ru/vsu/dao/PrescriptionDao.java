package ru.vsu.dao;


import ru.vsu.entities.PrescriptionEntity;

import javax.ejb.Stateless;

/**
 * Created by Влад on 28.10.2016.
 */

@Stateless
public class PrescriptionDao extends AbstractDao<Long, PrescriptionEntity> {


    public PrescriptionDao() {
        super(PrescriptionEntity.class);

    }

}
