package utility;

import model.Type;

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

    /**
     * Parses an identifier string.
     * @param ident The identifier string to parse.
     * @return The parsed identifier string.
     * @precondition The input string {@code ident} must not be null.
     * @postcondition Returns the input string without modification.
     */
    public static String parseIdent(String ident) {
        return ident;
    }

    /**
     * Parses a string to an integer.
     * @param token The string to parse.
     * @return The integer value of the string.
     * @precondition The input string {@code token} must be a valid numeric string and not null.
     * @postcondition Returns the integer representation of the input string.
     */
    private static int parseToInteger(String token) {
        return Integer.parseInt(token);
    }

    /**
     * Parses a string to a {@code Type} enum value.
     * @param token The string to parse.
     * @return The corresponding {@code Type} enum value.
     * @precondition The input string {@code token} must match one of the {@code Type} enum constants
     *                and must not be null.
     * @postcondition Returns the {@code Type} enum constant corresponding to the input string.
     */
    private static Type parseToType(String token) {
        return Type.valueOf(token.toUpperCase());
    }

    //todo: continue implementing parseForModel: Airport
}
