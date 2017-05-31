package ru.vsu.interfaces;

import ru.vsu.dto.PrescriptionDTO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Влад on 18.04.2017.
 */

@Local
public interface PrescriptionService extends Service<Long, PrescriptionDTO> {

    List<PrescriptionDTO> getEnded();
}
