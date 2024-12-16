package model;

public class Identification {
    private int id;
    private String airport_ident;

    public Identification(int id, String airport_ident) {
        this.id = id;
        this.airport_ident = airport_ident;
    }

    public int getId() {
        return id;
    }

    public String getAirport_ident() {
        return airport_ident;
    }
}
