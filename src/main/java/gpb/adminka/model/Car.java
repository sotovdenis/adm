package gpb.adminka.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Car {
    public int id;
    public String name;
    public String model;
    public String color;
    public int year;
    public int mechanicId;

    public Car(int id, String name, String model, String color, int year, int mechanicId) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mechanicId = mechanicId;
    }

    public Car() {

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
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }
}
