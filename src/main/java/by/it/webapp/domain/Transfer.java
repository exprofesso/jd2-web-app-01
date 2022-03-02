package by.it.webapp.domain;

import java.util.Objects;

public class Transfer extends Entity {
    private String typeOfTransport;

    public Transfer() {
    }

    public Transfer(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transfer)) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(typeOfTransport, transfer.typeOfTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfTransport);
    }

    @Override
    public String toString() {
        return "" + typeOfTransport;
    }
}
