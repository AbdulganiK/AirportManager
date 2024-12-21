package model;

/**
 * Represents the geographical position of a location using longitude and latitude coordinates.
 * <p>
 * This class provides precise location information based on the longitude and latitude values.
 * </p>
 */
public class Position {
    private double longitude;
    private double latitude;

    /**
     * Constructs a {@code Position} instance with the specified longitude and latitude.
     * @precondition {@code -180.0 <= longitude <= 180.0}, {@code -90.0 <= latitude <= 90.0}
     * @postcondition A new {@code Position} object is created with the specified coordinates.
     * @param longitude The longitude of the position. Must be between -180.0 and 180.0 degrees.
     * @param latitude  The latitude of the position. Must be between -90.0 and 90.0 degrees.
     */
    public Position(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * Returns the longitude of this position.
     * @return The longitude of the position.
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Returns the latitude of this position.
     * @return The latitude of the position.
     */
    public double getLatitude() {
        return latitude;
    }
}
