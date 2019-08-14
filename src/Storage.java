import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static List<Double> storage = new ArrayList<>();

    public Double saveNumber(Double number) {
        if (number != null) {
            storage.add(number);
            return storage.get(storage.size() - 1);
        } else {
            return null;
        }
    }

    public List<Double> getAll() {
        return new ArrayList<>(storage);
    }

    public int size() {
        return storage.size();
    }

    public void clear() {
         storage.clear();
    }
}
