package model;

public class Location {
    private String continent;
    private String region;
    private String country;
    private String municipality;

    public Location(String continent, String region, String country, String municipality) {
        this.continent = continent;
        this.region = region;
        this.country = country;
        this.municipality = municipality;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getMunicipality() {
        return municipality;
    }
}
