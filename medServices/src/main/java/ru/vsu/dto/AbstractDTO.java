package ru.vsu.dto;

/**
 * Created by Влад on 25.02.2017.
 */
public class AbstractDTO<TKey> {


    public AbstractDTO(TKey id) {
        this.id = id;
    }

    protected TKey id;

    public TKey getId(){
        return id;
    }
    public void setId(TKey id) {
        this.id = id;
    }
}
