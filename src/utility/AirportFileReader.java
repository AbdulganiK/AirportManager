package utility;
import Exceptions.NotACSVFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for Reading CSV Files.
 * @author Abdulgani Korkmaz
 * @version 1.0
 */

public class AirportFileReader {

    // instance attribute for the file path
    private String filePath;

    /**
     * Constructor can be called with or without a file path.
     * The standard path defined inside the Constant Interface will be used as the file path if no is given.
     * @param filePath to the csv file.
     * @precondition filePath to an existing csv file
     * @postcondition instance of AirPortFileReader
     */
    public AirportFileReader(String filePath)
    {
        this.setFilePath(filePath);
    }

    /**
     * <b>setFilePath</b> method should set the path to the CSV file.
     * @modifier is private since the method should only be used once by the constructor to set the path
     * @precondition a valid path to a csv file
     * @postcondition object attribute filePath is set
     * @param filePath to the comma seperated file
     */
    private void setFilePath(String filePath)
    {
        try
        {
            // checking if the filePath String ends with .csv
            if (filePath.endsWith(Constant.CSV_EXTENSION))
            {
                // setting the filepath
                this.filePath = filePath;
            }
            // block is executed when the filePath does not end with .csv
            else
            {
                // throwing a NotACSVFileException
                throw new NotACSVFileException();
            }
        }
        // catching the NotACSVFileException if thrown
        catch (NotACSVFileException e)
        {
            // logging the exception message in the terminal
            Console.log(e.getMessage());
            // exiting the programm with exit code -1
            System.exit(Constant.EXCEPTION_EXIT);
        }
    }

    /**
     * Constructor can be called with or without a file path.
     * The standard path defined inside the Constant Interface will be used as the file path if no is given.
     * @see Constant
     * @see Constant#STANDARD_PATH
     * @precondition the file to the filepath defined inside the constant interface needs to exist
     * @postcondition instance of AirPortFileReader
     */
    public AirportFileReader() {
        this(Constant.STANDARD_PATH);
    }
    /**
     * @precondition filePath have to be set before with the setFilePath method
     * @postcondition Array List of raw data stored as Strings
     * @return an Array List of strings which represents the data.
     * A single string represents a dataset.
     */
    public ArrayList<String> readFile()
    {
        // creating a try with resource block
        // initialising a scanner
        // try resource block is auto closing the instance of scanner
        try (Scanner scanner = new Scanner(new File(this.filePath)))
        {
            // logging a succesfull read message
            Console.log(LogMessages.SUCCESSFULLY_READ_FILE);
            // creating a local variable which stores the data as string
            ArrayList<String> data = new ArrayList<>();
            // creating a timer object
            Timer timer = new Timer();
            // starting the timer
            timer.start();
            // reading the lines until a next line exists
            while (scanner.hasNextLine())
            {
                // adding the line to the data arrayList
                data.add(scanner.nextLine());
            }
            // removing the first line(headline)
            data.removeFirst();
            // logging the amount of read lines
            Console.log(String.format(LogMessages.DATASET_COUNT, data.size()));
            // stopping the timer
            // logging the duration between start and stop time
            Console.log(String.format(LogMessages.DATASET_READ_DURATION, timer.stop()));
            // return the raw data
            return data;
        }
        // catching the FileNotFoundException if thrown
        catch (FileNotFoundException e)
        {
            // logging the caught exception message
            Console.log(ExceptionMessages.FILE_NOT_FOUND);
            // exiting the programm with exit code -1
            System.exit(Constant.EXCEPTION_EXIT);
        }
        return null;
    }
}
