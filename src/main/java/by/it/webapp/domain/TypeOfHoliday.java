package by.it.webapp.domain;

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

        return typeOfHoliday != null ? typeOfHoliday.equals(that.typeOfHoliday) : that.typeOfHoliday == null;
    }

    @Override
    public int hashCode() {
        return typeOfHoliday != null ? typeOfHoliday.hashCode() : 0;
    }


}
