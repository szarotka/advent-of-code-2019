package task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @ParameterizedTest
    @CsvSource({"12,2", "14,2", "1969,654", "100756,33583"})
    void findFuelForMass(Integer input, Integer expected) {
        Task1 task1 = new Task1();
        assertEquals(expected, task1.findFuelForMass(input));
    }

    @Test
    void calculateFuel() {
        String filePath = "src/test/resources/task1/task1.txt";
        Task1 task1 = new Task1();
        Long value = task1.calculateFuel(filePath);
        System.out.println(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"14,2", "1969,966", "100756,50346"})
    void findFuelForModuleWithFuel(Integer input, Long expected) {
        Task1 task1 = new Task1();
        assertEquals(expected, task1.findFuelForModuleWithFuel(input));
    }

    @Test
    void calculateCompleteFuel() {
        String filePath = "src/test/resources/task1/task1.txt";
        Task1 task1 = new Task1();
        Long value = task1.calculateCompleteFuel(filePath);
        System.out.println(value);
    }
}