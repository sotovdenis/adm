package gpb.adminka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mechanic {
    private int id;
    private String name;
    private int qualificationLevel;

    public Mechanic(int id, String name, int qualificationLevel) {
        this.id = id;
        this.name = name;
        this.qualificationLevel = qualificationLevel;
    }

    public Mechanic() {

    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Mechanic name cannot be null or empty");
        } else if (name.length() > 255 || name.length() < 3) {
            throw new IllegalArgumentException("Mechanic name must be between 3 and 255 characters");
        } else this.name = name;
    }

    public int getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(int qualificationLevel) {
        if (qualificationLevel < 0 || qualificationLevel > 10) {
            throw new IllegalArgumentException("Mechanic qualification level must be between 0 and 10");
        } else this.qualificationLevel = qualificationLevel;
    }
}
