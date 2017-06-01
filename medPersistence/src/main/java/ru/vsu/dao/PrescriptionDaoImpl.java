package ru.vsu.dao;


import ru.vsu.entities.PrescriptionEntity;
import ru.vsu.interfaces.PrescriptionDao;

import javax.ejb.Stateless;

/**
 * Created by Влад on 28.10.2016.
 */

@Stateless
public class PrescriptionDaoImpl extends AbstractDao<Long, PrescriptionEntity> implements PrescriptionDao{


    public PrescriptionDaoImpl() {
        super(PrescriptionEntity.class);

    }

}
