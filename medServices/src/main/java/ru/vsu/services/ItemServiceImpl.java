package ru.vsu.services;

import ru.vsu.dao.*;
import ru.vsu.dto.ItemDTO;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.entities.ItemEntity;
import ru.vsu.entities.MedicamentEntity;
import ru.vsu.exceptions.MedicamentNotFoundException;
import ru.vsu.interfaces.Dao;
import ru.vsu.interfaces.ItemDao;
import ru.vsu.interfaces.ItemService;
import ru.vsu.interfaces.MedicamentService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;


/**
 * Created by Влад on 25.02.2017.
 */

@Stateless
public class ItemServiceImpl extends AbstractService<Long, ItemEntity, ItemDTO> implements ItemService {

    @Inject
    private ItemDao _dao;

    @Inject
    private MedicamentService medicamentService;

    @Override
    protected Dao<Long, ItemEntity> getDao() {
        return _dao;
    }

    public void add(int count, Date expDate, String medicamentName)
            throws MedicamentNotFoundException {

        MedicamentDTO medicament = medicamentService.byName(medicamentName);

        if(medicament == null){
            throw new MedicamentNotFoundException(medicamentName);
        }

        ItemDTO item = new ItemDTO(null, expDate, count, medicament);
        add(item);

    }

    @Override
    public List<ItemDTO> getExpired() {
        //TODO
        throw new NotImplementedException();
    }

    @Override
    protected ItemDTO buildDTO(ItemEntity entity) {

        if(entity == null){
            return null;
        }

        MedicamentDTO medicament = new MedicamentDTO(
                entity.getMedicament().getId(),
                entity.getMedicament().getName(),
                entity.getMedicament().getDescription());

        return new ItemDTO(
                entity.getId(),
                entity.getExpirationDate(),
                entity.getCount(),
                medicament);
    }

    @Override
    protected ItemEntity buildEntity(ItemDTO dto) {

        if(dto == null){
            return null;
        }

        MedicamentEntity medicamentEntity = new MedicamentEntity(
                dto.getMedicament().getId(),
                dto.getMedicament().getName(),
                dto.getMedicament().getDescription());

        return new ItemEntity(
                dto.getId(),
                dto.getNumber(),
                dto.getExpirationDate(),
                medicamentEntity);
    }
}
