package utility;

public interface LogMessages {
    String SUCCESSFULLY_READ_FILE = Colors.GREEN + "Die Datei wurde erfolgreich gelesen." + Colors.RESET;
    String DATASET_COUNT = Colors.GREEN + "Es wurden %d Datensätze eingelesen." + Colors.RESET;
    String DATASET_READ_DURATION =  Colors.GREEN + "Das Lesen der Datensätze hat %d Nanosekunden gedauert" + Colors.RESET;
}
