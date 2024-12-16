package model;

public class Runway {
    private int width;
    private int length;
    private String surface;
    private byte lighted;

    public Runway(int width, int length, String surface, byte lighted) {
        this.width = width;
        this.length = length;
        this.surface = surface;
        this.lighted = lighted;
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

    public byte getLighted() {
        return lighted;
    }
}
