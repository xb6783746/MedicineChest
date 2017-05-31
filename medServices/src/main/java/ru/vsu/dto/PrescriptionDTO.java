package ru.vsu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Влад on 25.02.2017.
 */
public class PrescriptionDTO extends AbstractDTO<Long> {


    public PrescriptionDTO(){
        super(null);
    }
    public PrescriptionDTO(Long id, Date endDate, String description, MedicamentDTO medicament) {
        super(id);
        this.endDate = endDate;
        this.medicament = medicament;
        this.description = description;
    }

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date endDate;
    private String description;
    private MedicamentDTO medicament;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public MedicamentDTO getMedicament() {
        return medicament;
    }
    public void setMedicament(MedicamentDTO medicament) {
        this.medicament = medicament;
    }
}
