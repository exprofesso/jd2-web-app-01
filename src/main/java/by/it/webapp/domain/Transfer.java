package by.it.webapp.domain;

import java.util.Objects;

public class Transfer extends Entity {
    private long id;
    private String typeOfTransport;

    public Transfer() {
    }

    public Transfer(long id) {
        this.id = id;
    }

    public Transfer(long id, String typeOfTransport) {
        this.id = id;
        this.typeOfTransport = typeOfTransport;
    }


    public void setId(long id) {
        this.id = id;
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
        return id == transfer.id &&
                Objects.equals(typeOfTransport, transfer.typeOfTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfTransport);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", typeOfTransport='" + typeOfTransport + '\'' +
                '}';
    }
}
