package ru.vsu.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Влад on 25.02.2017.
 */

public interface Service<TKey, TDto> {

    TDto byId(TKey id);
    void delete(TKey id);
    void add(TDto item);
    void update(TDto item);
    List<TDto> all();
    List<TDto> where(Predicate<TDto> predicate);
    TDto first(Predicate<TDto> predicate);
}
