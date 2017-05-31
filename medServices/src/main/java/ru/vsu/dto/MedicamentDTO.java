package ru.vsu.dto;

/**
 * Created by Влад on 25.02.2017.
 */
public class MedicamentDTO extends AbstractDTO<Long> {


    public MedicamentDTO(){
        super(null);
    }

    public MedicamentDTO(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
