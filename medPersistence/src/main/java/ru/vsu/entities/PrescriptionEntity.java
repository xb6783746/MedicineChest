package ru.vsu.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Влад on 15.04.2017.
 */
@Entity
@Table(name = "prescription", schema = "med1", catalog = "")
public class PrescriptionEntity extends BaseEntity<Long>{
    private Long id;
    private String description;
    private Date endDate;
    private MedicamentEntity medicament;

    public PrescriptionEntity(){

    }

    public PrescriptionEntity(Long id, String description, Date endDate, MedicamentEntity medicament) {
        this.id = id;
        this.description = description;
        this.endDate = endDate;
        this.medicament = medicament;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrescriptionEntity that = (PrescriptionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "medicamentId", referencedColumnName = "id")
    public MedicamentEntity getMedicamentByMedicamentId() {
        return medicament;
    }

    public void setMedicamentByMedicamentId(MedicamentEntity medicamentByMedicamentId) {
        this.medicament = medicamentByMedicamentId;
    }
}
