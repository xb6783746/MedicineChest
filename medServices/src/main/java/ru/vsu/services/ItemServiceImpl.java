package ru.vsu.services;

import ru.vsu.dao.*;
import ru.vsu.dto.ItemDTO;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.entities.ItemEntity;
import ru.vsu.entities.MedicamentEntity;
import ru.vsu.interfaces.ItemService;
import ru.vsu.interfaces.MedicamentService;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;


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
    protected AbstractDao<Long, ItemEntity> getDao() {
        return _dao;
    }

    public void add(int count, Date expDate, String medicamentName) {

        MedicamentDTO tmp = medicamentService.byName(medicamentName);

        if(tmp != null){

            ItemDTO item = new ItemDTO(null, expDate, count, tmp);
            add(item);
        }

    }

    @Override
    public void getExpired() {
        //TODO
    }

    @Override
    protected ItemDTO buildDTO(ItemEntity entity) {

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
