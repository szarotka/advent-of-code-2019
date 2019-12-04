package task2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {

    public void calculate(String filePath) {
        List<Integer> values = readFile(filePath);

        values.set(1, 12);
        values.set(2, 2);

        values = changeValues(values);
        System.out.println(values);
    }

    List<Integer> changeValues(List<Integer> values) {
        for (int i = 0; i < values.size() - 4; i = i + 4) {
            boolean breakingCode = !changeValue(values, values.get(i), values.get(i + 1), values.get(i + 2), values.get(i + 3));
            if (breakingCode) {
                break;
            }
        }
        return values;
    }

    private boolean changeValue(List<Integer> allValues, Integer opcode, Integer value1Position, Integer value2Position, Integer resultPosition) {
        switch (opcode) {
            case 1:
                allValues.set(resultPosition, allValues.get(value1Position) + allValues.get(value2Position));
                return true;
            case 2:
                allValues.set(resultPosition, allValues.get(value1Position) * allValues.get(value2Position));
                return true;
            case 99:
                return false;
        }
        return false;
    }

    private List<Integer> readFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return parseStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    List<Integer> parseStream(Stream<String> stream) {
        return stream.map(s -> s.split(","))
                .flatMap(Arrays::stream)
                .mapToInt(value -> Integer.parseInt(value.trim()))
                .boxed()
                .collect(Collectors.toList());
    }
}
