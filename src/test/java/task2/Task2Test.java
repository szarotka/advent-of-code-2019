package task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    @Test
    void calculate() {
        String filePath = "src/test/resources/task2/task2.txt";
        Task2 task2 = new Task2();
        task2.calculate(filePath);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 0, 0, 0, 99; 2,0,0,0,99",
            "2,3,0,3,99; 2,3,0,6,99",
            "2,4,4,5,99,0; 2,4,4,5,99,9801",
            "1,1,1,4,99,5,6,0,99; 30,1,1,4,2,5,6,0,99"},
            delimiter = ';')
    void changeValues(String input, String expectedValue) {
        Task2 task2 = new Task2();
        List<Integer> values = task2.parseStream(Stream.of(input));
        List<Integer> result = task2.changeValues(values);

        List<Integer> expected = task2.parseStream(Stream.of(expectedValue));
        assertEquals(expected, result);
    }

}