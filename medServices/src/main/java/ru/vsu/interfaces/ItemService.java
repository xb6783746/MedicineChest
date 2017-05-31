package ru.vsu.interfaces;

import ru.vsu.dto.ItemDTO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;

/**
 * Created by Влад on 25.02.2017.
 */

@Local
public interface ItemService extends Service<Long, ItemDTO> {


    void add(int count, Date expDate, String medicamentName);
    void getExpired();
}
