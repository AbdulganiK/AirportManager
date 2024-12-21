package model;


/**
 * Lightning Class represents the ligting on a Airport Runway.
 * {@code isOn } attribute can be on/true or off/false
 */
public class Lighting {
    private boolean isOn;

    /**
     * Constructor which creates a instance of Lightning
     * @precondition isOn parameter must be
     * @postcondition a instance of lightning is created
     * @param isOn boolean defines that the lightning is on or off
     */
    public Lighting(boolean isOn) {
        this.isOn = isOn;
    }


}
