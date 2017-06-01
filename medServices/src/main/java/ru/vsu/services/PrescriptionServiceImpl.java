package ru.vsu.services;

import ru.vsu.dao.PrescriptionDaoImpl;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.dto.PrescriptionDTO;
import ru.vsu.entities.MedicamentEntity;
import ru.vsu.entities.PrescriptionEntity;
import ru.vsu.interfaces.Dao;
import ru.vsu.interfaces.PrescriptionDao;
import ru.vsu.interfaces.PrescriptionService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Влад on 27.02.2017.
 */

@Stateless
public class PrescriptionServiceImpl extends AbstractService<Long, PrescriptionEntity, PrescriptionDTO> implements PrescriptionService{


    @Inject
    private PrescriptionDao _dao;


    @Override
    protected Dao<Long, PrescriptionEntity> getDao() {

        return _dao;
    }

    @Override
    protected PrescriptionDTO buildDTO(PrescriptionEntity entity) {

        if(entity == null){
            return null;
        }

        MedicamentDTO medicamentDTO = new MedicamentDTO(
                entity.getMedicamentByMedicamentId().getId(),
                entity.getMedicamentByMedicamentId().getName(),
                entity.getMedicamentByMedicamentId().getDescription());

        return new PrescriptionDTO(
                entity.getId(),
                entity.getEndDate(),
                entity.getDescription(),
                medicamentDTO);

    }

    @Override
    protected PrescriptionEntity buildEntity(PrescriptionDTO dto) {

        if(dto == null){
            return null;
        }

        MedicamentEntity medicamentEntity = new MedicamentEntity(
                dto.getMedicament().getId(),
                dto.getMedicament().getName(),
                dto.getMedicament().getDescription());

        return new PrescriptionEntity(
                dto.getId(),
                dto.getDescription(),
                dto.getEndDate(),
                medicamentEntity);
    }

    @Override
    public List<PrescriptionDTO> getEnded() {
        //TODO
        throw new NotImplementedException();
    }
}
