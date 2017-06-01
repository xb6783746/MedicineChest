package ru.vsu.jsf.admin.beans;

import ru.vsu.dto.MedicamentDTO;
import ru.vsu.interfaces.MedicamentService;
import ru.vsu.interfaces.Service;
import ru.vsu.jsf.admin.abstractBean.AbstractAdminPage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Влад on 30.03.2017.
 */

@ManagedBean
@ViewScoped
public class MedicamentPageBean extends AbstractAdminPage<Long, MedicamentDTO> implements Serializable {

    @Inject
    private MedicamentService medicamentService;

    @Override
    protected Service<Long, MedicamentDTO> getService() {
        return medicamentService;
    }

    @Override
    protected MedicamentDTO create() {
        return new MedicamentDTO();
    }
}
