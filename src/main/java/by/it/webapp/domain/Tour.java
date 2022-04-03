package by.it.webapp.domain;

import java.sql.Date;
import java.util.Objects;

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
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(typeOfHoliday, tour.typeOfHoliday) &&
                Objects.equals(town, tour.town) &&
                Objects.equals(date, tour.date) &&
                Objects.equals(day, tour.day) &&
                food == tour.food &&
                Objects.equals(price, tour.price) &&
                Objects.equals(transfer, tour.transfer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfHoliday, town, date, day, food, price, transfer);
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
