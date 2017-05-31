package ru.vsu.dao;


import ru.vsu.entities.ItemEntity;

import javax.ejb.Stateless;


/**
 * Created by Влад on 27.10.2016.
 */

@Stateless
public class ItemDao extends AbstractDao<Long, ItemEntity> {

    public ItemDao() {
        super(ItemEntity.class);

    }

}
