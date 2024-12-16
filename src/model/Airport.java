package model;


public class Airport{

    public int getElevation() {
        return elevation;
    }

    private Identification id;
    private String type;
    private String name;
    private int elevation;
    private Position position;
    private Location location;
    private Runway runway;


    public Airport(int id, String airport_ident, String type, String name, double latitude_deg, double longitude_deg, int elevation_ft, String continent, String iso_country, String iso_region, String municipality, int runway_length_ft, int runway_width_ft, String runway_surface, byte runway_lighted) {
        this.id = new Identification(id, airport_ident);
        this.type = type;
        this.name = name;
        this.location = new Location(continent, iso_region, iso_country, municipality);
        this.position = new Position(longitude_deg, latitude_deg);
        this.elevation = elevation_ft;
        this.runway = new Runway(runway_width_ft, runway_length_ft, runway_surface, runway_lighted);

    }

    public Identification getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public Runway getRunway() {
        return runway;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {return location;}

    /**
     * @precondition instance of two Airport Objects
     * @postcondition
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Airport airport) {
            return this.id == airport.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%d", this.id);
    }
}
