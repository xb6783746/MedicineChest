package ru.vsu.jsf.admin.beans;

import ru.vsu.dto.ItemDTO;
import ru.vsu.dto.MedicamentDTO;
import ru.vsu.interfaces.ItemService;
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
public class ItemPageBean extends AbstractPageWithMedicamentSelecting<ItemDTO> implements Serializable {


    @Inject
    private ItemService itemService;

    @Override
    protected Service<Long, ItemDTO> getService() {
        return itemService;
    }

    @Override
    protected ItemDTO create() {
        return new ItemDTO();
    }

    @Override
    public void setSelectedItem(ItemDTO selectedItem) {
        super.setSelectedItem(selectedItem);

        this.selectedMedicament = selectedItem.getMedicament().getName();
    }
    @Override
    public void saveSelected() {
        MedicamentDTO medicamentDTO = medicamentService.byName(selectedMedicament);

        selectedItem.setMedicament(medicamentDTO);

        itemService.update(selectedItem);
    }

    @Override
    public void setPersistingItem(ItemDTO persistingItem) {
        super.setPersistingItem(persistingItem);

        this.persistingMedicament = persistingItem.getMedicament().getName();
    }

    @Override
    public void persist() {

        MedicamentDTO medicamentDTO = medicamentService.byName(persistingMedicament);

        persistingItem.setMedicament(medicamentDTO);

        itemService.add(persistingItem);
    }
}
