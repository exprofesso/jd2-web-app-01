package by.it.webapp.domain;

import java.util.Objects;

public class TypeOfHoliday extends Entity {

    private String typeOfHoliday;


    public TypeOfHoliday() {
    }

    public TypeOfHoliday(String typeOfHoliday) {
        this.typeOfHoliday = typeOfHoliday;
    }


    public String getTypeOfHoliday() {
        return typeOfHoliday;
    }

    public void setTypeOfHoliday(String typeOfHoliday) {
        this.typeOfHoliday = typeOfHoliday;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeOfHoliday)) return false;

        TypeOfHoliday that = (TypeOfHoliday) o;

        return Objects.equals(typeOfHoliday, that.typeOfHoliday);
    }

    @Override
    public int hashCode() {
        return typeOfHoliday != null ? typeOfHoliday.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "" + typeOfHoliday;
    }
}
