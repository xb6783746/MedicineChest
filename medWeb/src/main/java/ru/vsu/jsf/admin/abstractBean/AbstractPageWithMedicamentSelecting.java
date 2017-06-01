package ru.vsu.jsf.admin.abstractBean;

import ru.vsu.dto.AbstractDTO;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.interfaces.MedicamentService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Влад on 19.04.2017.
 */
public abstract class AbstractPageWithMedicamentSelecting<T extends AbstractDTO<Long>> extends AbstractAdminPage<Long, T> {

    @Inject
    protected MedicamentService medicamentService;

    protected String selectedMedicament;
    protected String persistingMedicament;


    public String getSelectedMedicament() {
        return selectedMedicament;
    }
    public void setSelectedMedicament(String selectedMedicament) {
        this.selectedMedicament = selectedMedicament;
    }

    public String getPersistingMedicament() {
        return persistingMedicament;
    }
    public void setPersistingMedicament(String persistingMedicament) {
        this.persistingMedicament = persistingMedicament;
    }

    public List<MedicamentDTO> getAllMedicaments(){

        return medicamentService.all();
    }

}
