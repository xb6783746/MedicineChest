package ru.vsu.services;

import ru.vsu.dto.AbstractDTO;
import ru.vsu.entities.BaseEntity;
import ru.vsu.interfaces.Dao;
import ru.vsu.interfaces.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



/**
 * Created by Влад on 25.02.2017.
 */
public abstract class AbstractService<TKey, TEntity extends BaseEntity<TKey>, TDto extends AbstractDTO<TKey>> implements Service<TKey, TDto> {


    protected abstract Dao<TKey, TEntity> getDao();

    @Override
    public TDto byId(TKey id){

        return buildDTO(getDao().byId(id));
    }

    @Override
    public void delete(TKey id){

        getDao().delete(id);
    }

    @Override
    public void add(TDto item){

        getDao().add(buildEntity(item));
    }

    @Override
    public void update(TDto item){

        getDao().update(buildEntity(item));
    }

    @Override
    public List<TDto> all(){

        return getDao()
                .getAll()
                .stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TDto> where(Predicate<TDto> predicate){

        //плохо
        return getDao()
                .getAll()
                .stream()
                .map(this::buildDTO)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public TDto first(Predicate<TDto> predicate){

        //плохо
        return getDao()
                .getAll()
                .stream()
                .map(this::buildDTO)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    protected abstract TDto buildDTO(TEntity entity);
    protected abstract TEntity buildEntity(TDto dto);
}
