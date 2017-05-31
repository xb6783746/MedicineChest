package ru.vsu.jsf.admin.abstractBean;

import ru.vsu.dto.AbstractDTO;
import ru.vsu.interfaces.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Влад on 18.04.2017.
 */

public abstract class AbstractAdminBean<TKey, TDto extends AbstractDTO<TKey>> implements Serializable{


    protected abstract Service<TKey, TDto> getService();
    protected abstract TDto getItem();

    protected TDto selectedItem;
    protected TDto addedItem;

    public List<TDto> getAllItems(){


        return getService().all();
    }

    public TDto getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(TDto selectedItem) {
        this.selectedItem = selectedItem;
    }

    public TDto getAddedItem() {
        return addedItem;
    }
    public void setAddedItem(TDto addedItem) {
        this.addedItem = addedItem;
    }

    public void saveSelected(){

        getService().update(selectedItem);
    }
    public void deleteSelected(){

        getService().delete(selectedItem.getId());
        selectedItem = getItem();
    }

    public void showAddDialog(){
        addedItem = getItem();
    }

    public void persist(){

        getService().add(addedItem);
    }


}
