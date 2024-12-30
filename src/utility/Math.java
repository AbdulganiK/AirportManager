package utility;

import java.util.ArrayList;

public class Math {
    public static Long calcToMM(Long ftValue) {
        return (long) (ftValue * 304.8);
    }
    public static Long calcToFT(Long mm) {
        return (long) (mm / 304.8);
    }

    public static double calcAverage(ArrayList<Long> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.EMPTY_NUMBERS_MESSAGE);
        }

        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        return sum / numbers.size();
    }
}
