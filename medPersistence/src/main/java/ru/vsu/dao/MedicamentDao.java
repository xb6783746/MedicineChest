package ru.vsu.dao;


import ru.vsu.entities.MedicamentEntity;

import javax.ejb.Stateless;


/**
 * Created by Влад on 27.10.2016.
 */

@Stateless
public class MedicamentDao extends AbstractDao<Long, MedicamentEntity> {


    public MedicamentDao() {
        super(MedicamentEntity.class);

    }

}
