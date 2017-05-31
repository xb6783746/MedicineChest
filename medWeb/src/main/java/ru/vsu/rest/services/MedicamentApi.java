package ru.vsu.rest.services;

import ru.vsu.dto.MedicamentDTO;
import ru.vsu.interfaces.MedicamentService;
import ru.vsu.interfaces.Service;
import ru.vsu.rest.AbstractApi;
import ru.vsu.services.MedicamentServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


@RequestScoped
@Path("/medicaments")
public class MedicamentApi extends AbstractApi<Long, MedicamentDTO> {


    @Inject
    private MedicamentService medicamentService;

    @Override
    protected Service<Long, MedicamentDTO> getService() {
        return medicamentService;
    }



}
