package model;

/**
 * Represents an identification record with an ID and an associated airport identifier.
 * <p>
 * This class provides a simple structure to store and retrieve identification data,
 * including a numeric ID and an airport identifier.
 * </p>
 *
 * @author Abdulgani Korkmaz
 * @version 1.0
 */
public class Identification {
    /**
     * The unique identification number.
     */
    private int id;

    /**
     * The airport identifier associated with the identification record.
     */
    private String airport_ident;

    /**
     * Constructs an {@code Identification} instance with the specified ID and airport identifier.
     * @precondition id, airport ident need to be valid (int, String)
     * @postcondition instance of Identification is created
     * @param id            The unique identification number.
     * @param airport_ident The airport identifier.
     */
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

    /**
     * Provides a string representation of the {@code Identification} object.
     *
     * @return A string in the format "Identification{id=ID, airport_ident='IDENT'}".
     */
    @Override
    public String toString() {
        return "Identification{" +
                "id=" + id +
                ", airport_ident='" + airport_ident + '\'' +
                '}';
    }
}
