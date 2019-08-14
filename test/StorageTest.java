import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StorageTest {
    private Storage storage = new Storage();
    private static final Double EXPECTED_MIN = 5.0;
    private static final Double EXPECTED_MAX = 25.0;
    private List<Double> list = new ArrayList<>(Arrays.asList(5.0, 10.0, 8d, 15.5, 13.85, 7d, 25.0));
    private Double expectedAverage = list.stream().mapToDouble(d -> d).sum() / list.size();

    @Before
    public void setUp() {
        storage.clear();
        for (Double number : list) {
            storage.saveNumber(number);
        }
    }

    @Test
    public void saveTest() {
        Double number = 3.0;
        assertEquals(number, storage.saveNumber(number));
        assertEquals(list.size() + 1, storage.size());
    }

    @Test
    public void getMinTest() {
        assertEquals(EXPECTED_MIN, StorageUtil.getMinNumber(storage.getAll()));
    }

    @Test
    public void getNullMinTest() {
        assertNull(StorageUtil.getMinNumber(EMPTY_LIST));
        assertNull(StorageUtil.getMinNumber(null));
    }

    @Test
    public void getMaxTest() {
        assertEquals(EXPECTED_MAX, StorageUtil.getMaxNumber(storage.getAll()));
    }

    @Test
    public void getNullMaxTest() {
        assertNull(StorageUtil.getMaxNumber(EMPTY_LIST));
        assertNull(StorageUtil.getMaxNumber(null));
    }

    @Test
    public void getAverageTest() {
        assertEquals(expectedAverage, StorageUtil.getAverageNumber(storage.getAll()));
    }

    @Test
    public void getNullAverageTest() {
        assertNull(StorageUtil.getAverageNumber(EMPTY_LIST));
        assertNull(StorageUtil.getAverageNumber(null));
    }

    @Test
    public void getAllTest() {
        List<Double> allList = storage.getAll();
        assertEquals(list.size(), allList.size());
        assertEquals(list, allList);
    }
}
