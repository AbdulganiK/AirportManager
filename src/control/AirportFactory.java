package control;

import Exceptions.NotAValidElevationException;
import Exceptions.NotAValidLatitudeException;
import Exceptions.NotAValidLongitudeException;
import model.Airport;
import model.Country;
import model.Type;
import utility.*;
import utility.Math;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A factory class for creating Airport objects.
 * This class provides methods to build a single Airport or a list of Airports
 * from a validated data set.
 */
public class AirportFactory {

    private final ArrayList<Airport> builtAirports = new ArrayList<>();
    private int deleteCount = 0;
    private int repairCount = 0;
    private HashMap<Type, Long> widthAverages = new HashMap<>();
    private HashMap<Type, Long> lengthAverages = new HashMap<>();
    private HashMap<Type, Long> elevationAverages = new HashMap<>();

    /**
     * Builds a single Airport object using the provided validated data set.
     *
     * @param formallyValidDataSet A string containing the validated data for creating the Airport.
     * @return An Airport object created using the provided data, or null if the input is invalid.
     * @precondition `validatedDataSet` must not be null or empty or must contain data in the correct format for creating an Airport..
     * @postcondition If the input is valid, an Airport object is created and returned
     */
    public void buildAirport(String formallyValidDataSet) {
        ArrayList<String> data = DataParser.convertDataSetToDataArray(formallyValidDataSet);
        if (isDataPotentiallyCorrect(data)) {
            try {
                this.builtAirports.add(createAirport(data));
            } catch (NotAValidLatitudeException | NotAValidLongitudeException | NotAValidElevationException e) {
                this.deleteCount++;
                //System.out.println("Airport Name: " + data.get(AirportFields.NAME) + " " +  e.getMessage());
            }
        } else {
            try {
                this.builtAirports.add(this.repairAirport(data));
            } catch (NotAValidLatitudeException | NotAValidLongitudeException | NotAValidElevationException e) {
                this.deleteCount++;
            }
        }
    }

    private Airport repairAirport(ArrayList<String> data) throws NotAValidLatitudeException, NotAValidLongitudeException, NotAValidElevationException {
        while (hasDataEmptyValues(data)) {
            Type airportType = DataParser.parseToType(data.get(AirportFields.TYPE));
            int emptyFieldIndex = data.indexOf(Constant.EMPTY);
            switch (emptyFieldIndex) {
                case AirportFields.RUNWAY_WIDTH_FT:
                    this.correctRunwayWidth(data, airportType);
                    break;
                case AirportFields.RUNWAY_LENGTH_FT:
                    this.correctRunwayLength(data, airportType);
                    break;
                case AirportFields.ELEVATION_FT:
                    this.correctElevation(data, airportType);
                    break;
                case AirportFields.RUNWAY_SURFACE:
                    this.correctRunwaySurface(data);
                    break;
                case AirportFields.RUNWAY_LIGHTED:
                    this.correctRunwayLighted(data);
                    break;
                case AirportFields.CONTINENT:
                    this.correctContinent(data);
                    break;
            }
        }
        this.repairCount++;
        return this.createAirport(data);
    }

    public void correctRunwayLighted(ArrayList<String> data) {
        data.set(AirportFields.RUNWAY_LIGHTED, Constant.UNLIGHTED);
    }

    public void correctRunwaySurface(ArrayList<String> data) {
        data.set(AirportFields.RUNWAY_SURFACE, Constant.UNKNOWN);
    }

    public void correctContinent(ArrayList<String> data) {
        Country country = Country.valueOf(data.get(AirportFields.ISO_COUNTRY));
        data.set(AirportFields.CONTINENT, country.getContinent().toString());
    }

    private void correctRunwayWidth(ArrayList<String> data, Type airportType) {
        this.calculateWidthAverageForTypeIfNotAlreadyCalculated(airportType);
        data.set(AirportFields.RUNWAY_WIDTH_FT, String.valueOf(Math.calcToFT(this.widthAverages.get(airportType))));

    }

    private void correctElevation(ArrayList<String> data, Type airportType) {
        this.calculateElevationAverageForTypeIfNotAlreadyCalculated(airportType);
        data.set(AirportFields.ELEVATION_FT, String.valueOf(Math.calcToFT(this.elevationAverages.get(airportType))));
    }

    public void correctRunwayLength(ArrayList<String> data, Type airportType) {
        this.calculateLengthAverageForTypeIfNotAlreadyCalculated(airportType);
        data.set(AirportFields.RUNWAY_LENGTH_FT, String.valueOf(Math.calcToFT(this.lengthAverages.get(airportType))));
    }

    private void calculateWidthAverageForTypeIfNotAlreadyCalculated(Type airportType) {
        if (!this.widthAverages.containsKey(airportType)) {
            ArrayList<Airport> airports = new AirportController(this.builtAirports).filterAirportsByType(airportType);
            ArrayList<Long> widths = new ArrayList<>();
            for (Airport airport : airports) {
                widths.add(airport.getRunway().getWidth());
            }
            Long average_width = (long) Math.calcAverage(widths);
            this.widthAverages.put(airportType, average_width);
        }
    }

    private void calculateElevationAverageForTypeIfNotAlreadyCalculated(Type airportType) {
        if (!this.elevationAverages.containsKey(airportType)) {
            ArrayList<Airport> airports = new AirportController(this.builtAirports).filterAirportsByType(airportType);
            ArrayList<Long> elevations = new ArrayList<>();
            for (Airport airport : airports) {
                elevations.add(airport.getLocation().getElevation());
            }
            Long average_elevation = (long) Math.calcAverage(elevations);
            this.elevationAverages.put(airportType, average_elevation);
        }
    }

    private void calculateLengthAverageForTypeIfNotAlreadyCalculated(Type airportType) {
        if (!this.lengthAverages.containsKey(airportType)) {
            ArrayList<Airport> airports = new AirportController(this.builtAirports).filterAirportsByType(airportType);
            ArrayList<Long> lengths = new ArrayList<>();
            for (Airport airport : airports) {
                lengths.add(airport.getRunway().getLength());
            }
            Long average_length = (long) Math.calcAverage(lengths);
            this.lengthAverages.put(airportType, average_length);
        }
    }

    private static boolean isDataPotentiallyCorrect(ArrayList<String> data) {
        return !data.contains(Constant.EMPTY);
    }

    private static boolean hasDataEmptyValues(ArrayList<String> data) {
        return data.contains(Constant.EMPTY);
    }

    private Airport createAirport(ArrayList<String> data) throws NotAValidLatitudeException, NotAValidLongitudeException, NotAValidElevationException {
        return new Airport(
                DataParser.parseToInt(data.get(AirportFields.ID)),
                data.get(AirportFields.AIRPORT_INDENT),
                DataParser.parseToType(data.get(AirportFields.TYPE)),
                data.get(AirportFields.NAME),
                DataParser.parseToLatitude(data.get(AirportFields.LATITUDE_DEG)),
                DataParser.parseToLongitude(data.get(AirportFields.LONGITUDE_DEG)),
                DataParser.parseToElevation(data.get(AirportFields.ELEVATION_FT)),
                DataParser.parseToContinent(data.get(AirportFields.CONTINENT)),
                DataParser.parseToCountry(data.get(AirportFields.ISO_COUNTRY)),
                data.get(AirportFields.ISO_REGION),
                data.get(AirportFields.MUNICIPALITY),
                DataParser.parseToLength(data.get(AirportFields.RUNWAY_LENGTH_FT)),
                DataParser.parseToWidth(data.get(AirportFields.RUNWAY_WIDTH_FT)),
                data.get(AirportFields.RUNWAY_SURFACE),
                DataParser.parseToLighted(data.get(AirportFields.RUNWAY_LIGHTED)));
    }


    /**
     * @param validatedData A string containing the validated data for creating multiple Airports.
     * @return An ArrayList of Airport objects created using the provided data, or null/empty list if the input is invalid.
     * @precondition The `validatedData` must not be null or empty, must contain data in the correct format for creating multiple Airport.
     * @postcondition If the input is valid, a non-null ArrayList of Airport objects is created and returned.If the input is invalid, the method returns null or an empty list (depending on the implementation).
     */
    public ArrayList<Airport> buildAirports(ArrayList<String> validatedData) {
        for (String validatedDataSet : validatedData) {
            this.buildAirport(validatedDataSet);
        }
        Console.log(String.format(LogMessages.AIRPORT_CREATED, this.builtAirports.size()));
        Console.log(String.format(LogMessages.AIRPORT_CORRECTED, this.repairCount));
        Console.log(String.format(LogMessages.AIRPORT_DELETED, this.deleteCount));
        return this.builtAirports;
    }
}
