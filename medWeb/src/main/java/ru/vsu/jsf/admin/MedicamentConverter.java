package ru.vsu.jsf.admin;

import ru.vsu.dto.MedicamentDTO;
import ru.vsu.interfaces.MedicamentService;
import ru.vsu.services.MedicamentServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Влад on 18.04.2017.
 */
@ManagedBean
@RequestScoped
public class MedicamentConverter implements Converter {


    @Inject
    private MedicamentService medicamentService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        return medicamentService.byName(s);

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        return ((MedicamentDTO)o).getName();
    }
}
