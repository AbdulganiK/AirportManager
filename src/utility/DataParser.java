package utility;

import Exceptions.NotAValidElevationException;
import Exceptions.NotAValidLatitudeException;
import Exceptions.NotAValidLongitudeException;
import model.Continent;
import model.Country;
import model.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



/**
 * A utility class for parsing various data formats.
 * <p>
 * Provides static methods to parse identifiers, integers, and custom types from strings.
 * </p>
 *
 * @author Abdulgani Korkmaz
 * @version 1.0
 */
public class DataParser {
    public static int parseToInt(String number) {
        return Integer.parseInt(number);
    }

    public static double parseToDouble(String doubleNum) {
        return Double.parseDouble(doubleNum);
    }

    public static ArrayList<String> convertDataSetToDataArray(String dataSet) {
        StringBuilder token = new StringBuilder();
        int tokenCounter = 0;
        String[] dataValueArray = new String[AirportFields.MAX_FIELDS];
        boolean quotesAppeared = false;
        for (char c : dataSet.toCharArray()) {
            if (c == Constant.QUOTES && !quotesAppeared) {
                quotesAppeared = true;
            } else if (c == Constant.QUOTES) {
                quotesAppeared = false;
            }
            if (c == Constant.SEPARATOR && !quotesAppeared) {
                dataValueArray[tokenCounter] = token.toString();
                token = new StringBuilder();
                tokenCounter++;
            } else {
                token.append(c);
            }
        }
        return new ArrayList<>(Arrays.asList(dataValueArray));
    }

    public static double parseToLatitude(String latitude) throws NotAValidLatitudeException {
        double latitude_double = parseToDouble(latitude);
        if (latitude_double >= Constant.MIN_LATITUDE_DEG && latitude_double <= Constant.MAX_LATITUDE_DEG) {
            return latitude_double;
        }
        throw new NotAValidLatitudeException(latitude_double);
    }

    public static double parseToLongitude(String longitude) throws NotAValidLongitudeException {
        double longitude_double = parseToDouble(longitude);
        if (longitude_double >= Constant.MIN_LONGITUDE_DEG && longitude_double <= Constant.MAX_LONGITUDE_DEG) {
            return longitude_double;
        }
        throw new NotAValidLongitudeException(longitude_double);
    }

    public static long parseToLong(String number) {
        return Long.parseLong(number);
    }

    public static Type parseToType(String type) {
        return Type.valueOf(type.toUpperCase());
    }

    public static Continent parseToContinent(String continent) {
        return Continent.valueOf(continent);
    }

    public static Country parseToCountry(String country) {
        return Country.valueOf(country);
    }
    public static long parseToElevation(String elevation) throws NotAValidElevationException {
        long elevation_long = parseToLong(elevation);
        long elevation_mm = Math.calcToMM(elevation_long);
        if (elevation_mm >= Constant.MIN_ELEVATION_MM && elevation_mm <= Constant.MAX_ELEVATION_MM) {
            return elevation_mm;
        }
        throw new NotAValidElevationException(elevation_mm);
    }


    public static long parseToWidth(String width) {
        long width_long_ft = parseToLong(width);
        return Math.calcToMM(width_long_ft);
    }

    public static long parseToLength(String length) {
        long length_long_ft = parseToLong(length);
        return Math.calcToMM(length_long_ft);
    }

    public static boolean parseToLighted(String lightedStr) {
        return !lightedStr.equals("0");
    }





}
