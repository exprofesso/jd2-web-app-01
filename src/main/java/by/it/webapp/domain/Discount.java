package by.it.webapp.domain;

public class Discount extends Entity {
    private int percent;

    public Discount() {
    }

    public Discount(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "percent=" + percent +
                '}';
    }
}
