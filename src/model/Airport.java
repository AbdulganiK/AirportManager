package model;

/**
 * Represents an Airport entity with attributes such as identification, type, name, position,
 * location, and runway details. Provides constructors to initialize airport objects and methods
 * to access attributes, check equality, and represent the airport as a string.
 *
 * @author Abdulgani Korkmaz
 * @version 1.0
 */
public class Airport {
    private Identification id;
    private Type type;
    private String name;
    private Position position;
    private Location location;
    private Runway runway;

    /**
     * Constructs an Airport object using detailed parameters.
     *
     * @param id            The unique ID of the airport.
     * @param airport_ident The airport identifier.
     * @param type          The type of the airport.
     * @param name          The name of the airport.
     * @param latitude_deg  The latitude of the airport's position in degrees.
     * @param longitude_deg The longitude of the airport's position in degrees.
     * @param elevation_ft  The elevation of the airport in feet.
     * @param continent     The continent where the airport is located.
     * @param iso_country   The ISO country code of the airport.
     * @param iso_region    The ISO region code of the airport.
     * @param municipality  The municipality where the airport is located.
     * @param runway_length_ft The length of the airport's runway in feet.
     * @param runway_width_ft  The width of the airport's runway in feet.
     * @param runway_surface   The surface type of the runway.
     * @param isOn   Indicates if the runway is lighted.
     *
     * @precondition All input parameters must be non-null, and numeric values should be within valid ranges.
     * @postcondition A new Airport object is initialized with the provided values.
     */
    public Airport(int id, String airport_ident, Type type, String name, double latitude_deg, double longitude_deg, long elevation_ft, Continent continent, Country iso_country, String iso_region, String municipality, long runway_length_ft, long runway_width_ft, String runway_surface, boolean isOn) {
        this.id = new Identification(id, airport_ident);
        this.type = type;
        this.name = name;
        this.location = new Location(continent, iso_region, iso_country, municipality, elevation_ft);
        this.position = new Position(longitude_deg, latitude_deg);
        this.runway = new Runway(runway_width_ft, runway_length_ft, runway_surface, new Lighting(isOn));
    }

    /**
     * Constructs an Airport object using pre-defined objects.
     *
     * @param id       The identification object of the airport.
     * @param type     The type of the airport.
     * @param name     The name of the airport.
     * @param position The position object representing the location.
     * @param location The location object with geographical details.
     * @param runway   The runway object containing runway details.
     *
     * @precondition All parameters must be non-null.
     * @postcondition A new Airport object is initialized with the provided objects.
     */
    public Airport(Identification id, Type type, String name, Position position, Location location, Runway runway) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.position = position;
        this.location = location;
        this.runway = runway;
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

    public Type getType() {
        return this.type;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Checks if this airport is equal to another object based on the airport's ID.
     *
     * @param obj The object to compare with this airport.
     * @return {@code true} if the objects are equal based on their IDs; {@code false} otherwise.
     *
     * @precondition The input object must be non-null.
     * @postcondition Returns true if the airport IDs match; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Airport airport) {
            return this.id == airport.id;
        }
        return false;
    }

    /**
     * Converts the airport to a string representation.
     *
     * @return A string representation of the airport's ID.
     * @postcondition The ID of the airport is returned as a string.
     */
    @Override
    public String toString() {
        return String.format("%d", this.id);
    }
}
