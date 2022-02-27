package by.it.webapp.domain;

import java.sql.Date;

public class Tour extends Entity {
    private TypeOfHoliday typeOfHoliday;
    private String town;
    private java.sql.Date date;
    private Integer day;
    private Food food;
    private Integer price;
    private Transfer transfer;


    public Tour() {
    }

    public TypeOfHoliday getTypeOfHoliday() {
        return typeOfHoliday;
    }

    public void setTypeOfHoliday(TypeOfHoliday typeOfHoliday) {
        this.typeOfHoliday = typeOfHoliday;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tour)) return false;

        Tour tour = (Tour) o;

        if (typeOfHoliday != null ? !typeOfHoliday.equals(tour.typeOfHoliday) : tour.typeOfHoliday != null)
            return false;
        if (town != null ? !town.equals(tour.town) : tour.town != null) return false;
        if (date != null ? !date.equals(tour.date) : tour.date != null) return false;
        if (day != null ? !day.equals(tour.day) : tour.day != null) return false;
        if (food != tour.food) return false;
        if (price != null ? !price.equals(tour.price) : tour.price != null) return false;
        return transfer != null ? transfer.equals(tour.transfer) : tour.transfer == null;
    }

    @Override
    public int hashCode() {
        int result = typeOfHoliday != null ? typeOfHoliday.hashCode() : 0;
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (transfer != null ? transfer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "typeOfHoliday=" + typeOfHoliday +
                ", town='" + town + '\'' +
                ", date=" + date +
                ", day=" + day +
                ", food=" + food +
                ", price=" + price +
                ", transfer=" + transfer +
                '}';
    }
}
