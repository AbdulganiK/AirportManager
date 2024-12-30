package control;

import utility.*;

import java.util.ArrayList;

/**
 * A controller class responsible for validating and correcting data sets.
 * <p>
 * This class processes raw data, validates it, and provides methods to remove,
 * correct, and assess the validity of data sets.
 * </p>
 *
 * @author Abdulgani Korkmaz
 * @version 1.0
 */
public class DataValidationController {
    private final ArrayList<String> rawData;
    private final ArrayList<String> formallyValidData = new ArrayList<>();
    private final ArrayList<String> potentiallyCorrectData = new ArrayList<>();

    /**
     * Constructs a DataValidationController with the given raw data.
     * @param rawData An ArrayList containing raw data strings to be validated.
     * @precondition {@code rawData} must not be null.
     * @postcondition A new instance of DataValidationController is created with the given raw data.
     */
    public DataValidationController(ArrayList<String> rawData) {
        this.rawData = rawData;
    }


    /**
     * Validates a specific data set.
     * @param dataSet The data set to validate.
     * @precondition {@code dataSet} must not be null.
     * @postcondition The data set is validated or flagged for correction/removal.
     */
    private void validateDataSet(String dataSet) {
        if (isDataSetPotentiallyCorrect(dataSet)) {
            this.potentiallyCorrectData.add(dataSet);
        } else if (isDataSetFormallyValid(dataSet)) {
            this.formallyValidData.add(dataSet);
        } else {
             //System.out.println(dataSet);
        }
    }


    /**
     * Validates a list of data sets by checking each entry for validity.
     * @precondition {@code data} must not be null, and each element in {@code data} must be a non-null string.
     * @postcondition Each data set in the list is validated. Invalid or uncorrectable data sets may be removed or flagged.
     */
    public ArrayList<String> validateData() {
        ArrayList<String> validatedData = new ArrayList<>();
        for (String dataSet : this.rawData) {
            this.validateDataSet(dataSet);
        }
        validatedData.addAll(this.potentiallyCorrectData);
        validatedData.addAll(this.formallyValidData);
        Console.log(String.format(LogMessages.DATASET_VALIDATED_COUNT, validatedData.size(), this.rawData.size()));
        return validatedData;
    }

    /**
     * Checks if a data set is formally valid.
     * @param dataSet The data set to check.
     * @return {@code true} if the data set is valid; {@code false} otherwise.
     * @precondition {@code dataSet} must not be null.
     * @postcondition Returns {@code true} if the data set meets all validation criteria; {@code false} otherwise.
     */
    private boolean isDataSetFormallyValid(String dataSet) {
        return dataSet.matches(RegexPatterns.FORMALLY_VALID_DATASET_PATTERN);
    }

    private boolean isDataSetPotentiallyCorrect(String dataSet) {
        return dataSet.matches(RegexPatterns.POTTENTIALLY_CORRECT_DATASET_PATTERN);
    }
}
