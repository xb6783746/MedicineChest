package ru.vsu.rest.services;

import ru.vsu.dto.PrescriptionDTO;
import ru.vsu.interfaces.PrescriptionService;
import ru.vsu.interfaces.Service;
import ru.vsu.rest.AbstractApi;
import ru.vsu.services.PrescriptionServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


@RequestScoped
@Path("/prescriptions")
public class PrescriptionApi extends AbstractApi<Long, PrescriptionDTO> {


    @Inject
    private PrescriptionService prescriptionService;


    @Override
    protected Service<Long, PrescriptionDTO> getService() {
        return prescriptionService;
    }
}
