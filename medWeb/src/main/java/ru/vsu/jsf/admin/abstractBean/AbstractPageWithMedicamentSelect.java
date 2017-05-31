package ru.vsu.jsf.admin.abstractBean;

import ru.vsu.dto.AbstractDTO;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.interfaces.MedicamentService;
import ru.vsu.services.MedicamentServiceImpl;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Влад on 19.04.2017.
 */
public abstract class AbstractPageWithMedicamentSelect<T extends AbstractDTO<Long>> extends AbstractAdminBean<Long, T> {

    @Inject
    protected MedicamentService medicamentService;

    protected String selectedMedicament;
    protected String addedMedicament;


    public String getSelectedMedicament() {
        return selectedMedicament;
    }
    public void setSelectedMedicament(String selectedMedicament) {
        this.selectedMedicament = selectedMedicament;
    }

    public String getAddedMedicament() {
        return addedMedicament;
    }
    public void setAddedMedicament(String addedMedicament) {
        this.addedMedicament = addedMedicament;
    }

    public List<MedicamentDTO> getAllMedicaments(){

        return medicamentService.all();
    }

}
