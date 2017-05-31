package ru.vsu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Влад on 25.02.2017.
 */
public class ItemDTO extends AbstractDTO<Long>{



    public ItemDTO(){
        super(null);
    }
    public ItemDTO(Long id, Date date, int num, MedicamentDTO medicament) {
        super(id);

        this.expirationDate = date;
        this.number = num;
        this.medicament = medicament;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date expirationDate;
    private int number;
    private MedicamentDTO medicament;


    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public MedicamentDTO getMedicament() {
        return medicament;
    }
    public void setMedicament(MedicamentDTO medicament) {
        this.medicament = medicament;
    }
}
