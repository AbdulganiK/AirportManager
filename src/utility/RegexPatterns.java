package utility;


import model.Continent;
import model.Country;
import model.Type;


public interface RegexPatterns {
    String GROUP_OPENING = "(";
    String GROUP_CLOSING = ")";
    String OR = "|";
    String ONE_OR_MORE = "+";
    String NOTHING_OR_MORE = "*";
    String OPTIONAL = "?";
    String ID_PATTERN = "[0-9]";
    String AIRPORT_IDENT_PATTERN = "[0-9A-Z-]";
    String TYPE_PATTERN = getTypePattern();
    String NAME_PATTERN = String.format("(\"[^\"]*\"|[^%s]+)\"", Constant.SEPARATOR);
    String LONGITUDE_PATTERN = "[-0-9.]";
    String LATITUDE_PATTERN = "[-0-9.]";
    String ELEVATION_PATTERN = "[0-9.-]";
    String CONTINENT_PATTERN = getContinentPattern();
    String COUNTRY_PATTERN = getCountryPattern();
    String REGION_PATTERN = COUNTRY_PATTERN + "-" + "[A-Z0-9-]";
    String MUNICIPALITY_PATTERN = "(\"[^\"]*\"|[^,]+)\"";
    String WIDTH_PATTERN = "[0-9]";
    String HEIGHT_PATTERN = "[0-9]";
    String RUNWAY_SURFACE_PATTERN = "[-A-Za-z \\/]";
    String RUNWAY_LIGHTED_PATTERN = "(0|1)";
    String FORMALLY_VALID_DATASET_PATTERN =
            ID_PATTERN + ONE_OR_MORE +
            Constant.SEPARATOR +
            AIRPORT_IDENT_PATTERN + ONE_OR_MORE +
            Constant.SEPARATOR +
            TYPE_PATTERN +
            Constant.SEPARATOR +
            NAME_PATTERN + NOTHING_OR_MORE +
            Constant.SEPARATOR +
            LONGITUDE_PATTERN + ONE_OR_MORE +
            Constant.SEPARATOR +
            LATITUDE_PATTERN + ONE_OR_MORE +
            Constant.SEPARATOR +
            ELEVATION_PATTERN +  NOTHING_OR_MORE +
            Constant.SEPARATOR +
            CONTINENT_PATTERN +
            Constant.SEPARATOR +
            COUNTRY_PATTERN +
            Constant.SEPARATOR +
            REGION_PATTERN + ONE_OR_MORE +
            Constant.SEPARATOR +
            MUNICIPALITY_PATTERN + NOTHING_OR_MORE +
            Constant.SEPARATOR +
            WIDTH_PATTERN + NOTHING_OR_MORE +
            Constant.SEPARATOR +
            HEIGHT_PATTERN + NOTHING_OR_MORE +
            Constant.SEPARATOR +
            RUNWAY_SURFACE_PATTERN + NOTHING_OR_MORE +
            Constant.SEPARATOR +
            RUNWAY_LIGHTED_PATTERN + OPTIONAL +
            Constant.SEPARATOR;
    String POTTENTIALLY_CORRECT_DATASET_PATTERN =
            ID_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    AIRPORT_IDENT_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    TYPE_PATTERN +
                    Constant.SEPARATOR +
                    NAME_PATTERN + NOTHING_OR_MORE +
                    Constant.SEPARATOR +
                    LONGITUDE_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    LATITUDE_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    ELEVATION_PATTERN +  ONE_OR_MORE +
                    Constant.SEPARATOR +
                    CONTINENT_PATTERN +
                    Constant.SEPARATOR +
                    COUNTRY_PATTERN +
                    Constant.SEPARATOR +
                    REGION_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    MUNICIPALITY_PATTERN + NOTHING_OR_MORE +
                    Constant.SEPARATOR +
                    WIDTH_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    HEIGHT_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    RUNWAY_SURFACE_PATTERN + ONE_OR_MORE +
                    Constant.SEPARATOR +
                    RUNWAY_LIGHTED_PATTERN +
                    Constant.SEPARATOR;



    private static String getTypePattern() {
        StringBuilder pattern = new StringBuilder(GROUP_OPENING);
        Type[] types = Type.values();
        for (Type type : types) {
            pattern.append(type.toString().toLowerCase()).append(OR);
        }
        // removing redundant char |
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(GROUP_CLOSING);
        return pattern.toString();
    }

    private static String getContinentPattern() {
        StringBuilder pattern = new StringBuilder(GROUP_OPENING);
        for (Continent continent :  Continent.values()) {
            pattern.append(continent.toString()).append(OR);
        }
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(GROUP_CLOSING);
        pattern.append(OPTIONAL);
        return pattern.toString();
    }

    private static String getCountryPattern() {
        StringBuilder pattern = new StringBuilder(GROUP_OPENING);
        for (Country country : Country.values()) {
            pattern.append(country.toString(), Constant.START_COUNTRY_STRING, Constant.END_COUNTRY_STRING).append(OR);
        }
        pattern.deleteCharAt(pattern.length() - 1);
        pattern.append(GROUP_CLOSING);
        return pattern.toString();
    }


}
