package task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Task3Test {

    @Test
    void findTheShortestDistanceFromFile() {
        String filePath = "src/test/resources/task3/task3.txt";
        Task3 task3 = new Task3();
        task3.findTheShortestDistanceFromFile(filePath);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "R8,U5,L5,D3;U7,R6,D4,L4",
            "R75,D30,R83,U83,L12,D49,R71,U7,L72;U62,R66,U55,R34,D71,R55,D58,R83"
    }, delimiter = ';')
    void findTheShortestDistance(String line1, String line2) {
        Task3 task3 = new Task3();
        task3.findTheShortestDistance(line1, line2);
    }

}