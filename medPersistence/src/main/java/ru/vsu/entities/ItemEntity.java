package ru.vsu.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Влад on 15.04.2017.
 */
@Entity
@Table(name = "item", schema = "med1", catalog = "")
public class ItemEntity extends BaseEntity<Long>{

    private Long id;
    private Integer count;
    private Date expirationDate;
    private MedicamentEntity medicament;

    public ItemEntity(){

    }

    public ItemEntity(Long id, Integer count, Date expirationDate, MedicamentEntity medicament) {
        this.id = id;
        this.count = count;
        this.expirationDate = expirationDate;
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
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "expirationDate")
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @ManyToOne
    @JoinColumn(name = "medicamentId", referencedColumnName = "id")
    public MedicamentEntity getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentEntity medicament) {
        this.medicament = medicament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        return result;
    }
}
