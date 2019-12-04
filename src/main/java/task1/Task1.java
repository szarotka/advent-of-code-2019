package task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    public Long calculateCompleteFuel(String filePath) {
        List<Integer> values = readFile(filePath);
        return values.stream()
                .map(this::findFuelForModuleWithFuel)
                .mapToLong(Long::valueOf)
                .sum();
    }

    Long findFuelForModuleWithFuel(Integer mass) {
        Integer requiredFuel = findFuelForMass(mass);
        Long sum = Long.valueOf(requiredFuel);
        while (requiredFuel >= 0) {
            requiredFuel = findFuelForMass(requiredFuel);
            if (requiredFuel>=0) {
                sum += requiredFuel;
            }
        }
        return sum;
    }

    public Long calculateFuel(String filePath) {
        List<Integer> values = readFile(filePath);
        return values.stream()
                .map(this::findFuelForMass)
                .mapToLong(Long::valueOf)
                .sum();
    }

    Integer findFuelForMass(Integer mass) {
        return mass / 3 - 2;
    }

    private List<Integer> readFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return stream.map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
