package ru.vsu.interfaces;

import ru.vsu.dto.MedicamentDTO;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by Влад on 18.04.2017.
 */

@Stateless
public interface MedicamentService extends Service<Long, MedicamentDTO> {

    MedicamentDTO byName(String name);
}
