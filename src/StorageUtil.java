import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;

public class StorageUtil {

    private StorageUtil() {}

    public static Double getMinNumber(List<Double> list) {
        if (isValidList(list)) {
            return Collections.min(list);
        }
        return null;
    }

    public static Double getMaxNumber(List<Double> list) {
        if (isValidList(list)) {
            return Collections.max(list);
        }
        return null;
    }

    public static Double getAverageNumber(List<Double> list) {
        if (isValidList(list)) {
            OptionalDouble average = list.stream().mapToDouble(number -> number).average();
            return average.isPresent() ? average.getAsDouble() : null;
        }
        return null;
    }

    private static boolean isValidList(List<Double> list) {
        return (list != null && !list.isEmpty());
    }
}
