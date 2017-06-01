package ru.vsu.jsf.admin.beans;

import ru.vsu.dto.MedicamentDTO;
import ru.vsu.dto.PrescriptionDTO;
import ru.vsu.interfaces.PrescriptionService;
import ru.vsu.interfaces.Service;
import ru.vsu.jsf.admin.abstractBean.AbstractPageWithMedicamentSelecting;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by Влад on 18.04.2017.
 */

@ManagedBean
@ViewScoped
public class PrescriptionPageBean extends AbstractPageWithMedicamentSelecting<PrescriptionDTO> implements Serializable {


    @Inject
    private PrescriptionService prescriptionService;


    @Override
    protected Service<Long, PrescriptionDTO> getService() {
        return prescriptionService;
    }

    @Override
    protected PrescriptionDTO create() {
        return new PrescriptionDTO();
    }

    @Override
    public void setSelectedItem(PrescriptionDTO selectedItem) {
        super.setSelectedItem(selectedItem);

        this.selectedMedicament = selectedItem.getMedicament().getName();
    }
    @Override
    public void setPersistingItem(PrescriptionDTO persistingItem) {
        super.setPersistingItem(persistingItem);

        this.persistingMedicament = persistingItem.getMedicament().getName();
    }

    @Override
    public void saveSelected() {
        MedicamentDTO medicamentDTO = medicamentService.byName(selectedMedicament);

        selectedItem.setMedicament(medicamentDTO);

        prescriptionService.update(selectedItem);
    }

    @Override
    public void persist() {

        MedicamentDTO medicamentDTO = medicamentService.byName(persistingMedicament);

        persistingItem.setMedicament(medicamentDTO);

        prescriptionService.add(persistingItem);
    }

}
