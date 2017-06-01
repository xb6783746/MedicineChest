package ru.vsu.rest.services;

import ru.vsu.dto.ItemDTO;
import ru.vsu.exceptions.MedicamentNotFoundException;
import ru.vsu.interfaces.ItemService;
import ru.vsu.interfaces.MedicamentService;
import ru.vsu.interfaces.Service;
import ru.vsu.rest.AbstractApi;
import ru.vsu.services.MedicamentServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



@RequestScoped
@Path("/items")
public class ItemApi extends AbstractApi<Long, ItemDTO> {


    @Inject
    private ItemService itemService;

    @Inject
    private MedicamentService medService;

    @PUT
    public void add(@FormParam("medName") String medName,
                    @FormParam("count") Integer count,
                    @FormParam("expDate") String expirationDate){

        try {

            DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            Date date = format.parse(expirationDate);

            itemService.add(count, date, medName);

        } catch (ParseException e) {
            e.printStackTrace();
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity("Date format error").build()
            );

        } catch (MedicamentNotFoundException e) {
            e.printStackTrace();
            throw new WebApplicationException(
                    Response.status(Response.Status.NOT_FOUND)
                    .entity("Medicament with specified name is not exists").build()
            );
        }

    }


    @Override
    protected Service<Long, ItemDTO> getService() {
        return itemService;
    }
}
