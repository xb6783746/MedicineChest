package ru.vsu.jsf.admin.abstractBean;

import ru.vsu.dto.AbstractDTO;
import ru.vsu.interfaces.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Влад on 18.04.2017.
 */

public abstract class AbstractAdminPage<TKey, TDto extends AbstractDTO<TKey>> implements Serializable{


    protected abstract Service<TKey, TDto> getService();
    protected abstract TDto create();

    protected TDto selectedItem;
    protected TDto persistingItem;

    public List<TDto> getAllItems(){


        return getService().all();
    }

    public TDto getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(TDto selectedItem) {
        this.selectedItem = selectedItem;
    }

    public TDto getPersistingItem() {
        return persistingItem;
    }
    public void setPersistingItem(TDto persistingItem) {
        this.persistingItem = persistingItem;
    }

    public void saveSelected(){

        getService().update(selectedItem);
    }
    public void deleteSelected(){

        getService().delete(selectedItem.getId());
        selectedItem = create();
    }

    public void showAddDialog(){
        persistingItem = create();
    }

    public void persist(){

        getService().add(persistingItem);
    }


}
