package model;

/**
 * Represents the geographical location of an airport, including its continent, region,
 * country, municipality, and elevation.
 * <p>
 * This class encapsulates all the relevant geographical data associated with a specific airport.
 * </p>
 */
public class Location {
    private Continent continent;
    private String region;
    private Country country;
    private String municipality;
    private int elevation;

    /**
     * Constructs a {@code Location} instance with the specified geographical data.
     * @precondition {@code continent != null}, {@code region != null}, {@code country != null},
     *               {@code municipality != null}, {@code elevation >= 0}
     * @postcondition A new {@code Location} object is created with the specified values.
     * @param continent    The continent where the location is situated.
     * @param region       The specific region within the country.
     * @param country      The country where the location is situated.
     * @param municipality The municipality or city where the location is found.
     * @param elevation    The elevation above sea level (in feet). Must be non-negative.
     */
    public Location(Continent continent, String region, Country country, String municipality, int elevation) {
        this.continent = continent;
        this.region = region;
        this.country = country;
        this.municipality = municipality;
        this.elevation = elevation;
    }

    public Continent getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public Country getCountry() {
        return country;
    }

    public String getMunicipality() {
        return municipality;
    }

    public int getElevation() {
        return this.elevation;
    }
}
