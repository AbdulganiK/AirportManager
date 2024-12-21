package model;

/**
 * Represents a runway with attributes such as width, length, surface type, and lighting.
 * <p>
 * This class provides detailed information about the characteristics of a runway.
 * </p>
 */
public class Runway {
    private int width;
    private int length;
    private String surface;
    private Lighting lighting;

    /**
     * Constructs a {@code Runway} instance with the specified attributes.
     * @precondition {@code width > 0}, {@code length > 0}, {@code surface != null && !surface.isEmpty()}
     * @postcondition A new {@code Runway} object is created with the specified dimensions, surface type, and lighting status.
     * @param width   The width of the runway in meters. Must be greater than 0.
     * @param length  The length of the runway in meters. Must be greater than 0.
     * @param surface The surface type of the runway (e.g., "asphalt", "concrete"). Cannot be null or empty.
     * @param lighting Indicates the lightning of the runway
     */
    public Runway(int width, int length, String surface, Lighting lighting) {
        this.width = width;
        this.length = length;
        this.surface = surface;
        this.lighting = lighting;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }


    public String getSurface() {
        return surface;
    }

}
