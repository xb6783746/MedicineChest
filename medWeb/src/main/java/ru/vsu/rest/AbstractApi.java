package ru.vsu.rest;

import ru.vsu.dto.AbstractDTO;
import ru.vsu.interfaces.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Влад on 31.05.2017.
 */
public abstract class AbstractApi<TKey, TDto extends AbstractDTO<TKey>> {


    protected abstract Service<TKey, TDto> getService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public TDto getById(@PathParam("id") TKey id) {

        TDto dto = getService().byId(id);

        if (dto == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return dto;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TDto> getAll() {

        List<TDto> list = getService().all();

        return list;
    }

    @DELETE
    @Path("/{id}")
    public void del(@FormParam("id") TKey id){

        getService().delete(id);
    }
}
