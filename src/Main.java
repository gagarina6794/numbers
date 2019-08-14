import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.saveNumber(2.0);
        storage.saveNumber(1d);
        storage.saveNumber(3d);
        storage.saveNumber(4.0);
        storage.saveNumber(5.0);
        List<Double> list = storage.getAll();
        Double min = StorageUtil.getMinNumber(list);
        Double max = StorageUtil.getMaxNumber(list);
        Double average = StorageUtil.getAverageNumber(list);
        System.out.println("min number = " + min);
        System.out.println("max number = " + max);
        System.out.println("average number = " + average);
    }
}
