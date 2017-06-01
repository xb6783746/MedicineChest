package ru.vsu.interfaces;

import ru.vsu.entities.ItemEntity;
import ru.vsu.entities.MedicamentEntity;

/**
 * Created by Влад on 01.06.2017.
 */
public interface MedicamentDao extends Dao<Long, MedicamentEntity>{

    MedicamentEntity byName(String name);
}
