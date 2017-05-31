package ru.vsu.services;

import ru.vsu.dao.AbstractDao;
import ru.vsu.dao.PrescriptionDao;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.dto.PrescriptionDTO;
import ru.vsu.entities.MedicamentEntity;
import ru.vsu.entities.PrescriptionEntity;
import ru.vsu.interfaces.PrescriptionService;

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
    protected AbstractDao<Long, PrescriptionEntity> getDao() {

        return _dao;
    }

    @Override
    protected PrescriptionDTO buildDTO(PrescriptionEntity entity) {

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
        return null;
    }
}
