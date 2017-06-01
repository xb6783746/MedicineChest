package ru.vsu.dao;


import ru.vsu.entities.ItemEntity;
import ru.vsu.interfaces.ItemDao;

import javax.ejb.Stateless;


/**
 * Created by Влад on 27.10.2016.
 */

@Stateless
public class ItemDaoImpl extends AbstractDao<Long, ItemEntity> implements ItemDao{

    public ItemDaoImpl() {
        super(ItemEntity.class);

    }

}
