package ru.vsu.services;

import ru.vsu.dto.MedicamentDTO;
import ru.vsu.entities.MedicamentEntity;
import ru.vsu.interfaces.Dao;
import ru.vsu.interfaces.MedicamentDao;
import ru.vsu.interfaces.MedicamentService;


import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Влад on 27.02.2017.
 */

@Stateless
public class MedicamentServiceImpl extends AbstractService<Long, MedicamentEntity, MedicamentDTO> implements MedicamentService{


    @Inject
    private MedicamentDao _dao;

    @Override
    public MedicamentDTO byName(String name){

        return buildDTO(_dao.byName(name));
    }

    @Override
    protected Dao<Long, MedicamentEntity> getDao() {

        return _dao;
    }

    @Override
    protected MedicamentDTO buildDTO(MedicamentEntity entity) {

        if(entity == null){
            return null;
        }

        return new MedicamentDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription());

    }

    @Override
    protected MedicamentEntity buildEntity(MedicamentDTO dto) {

        if(dto == null){
            return null;
        }

        return new MedicamentEntity(
                dto.getId(),
                dto.getName(),
                dto.getDescription());
    }

}
