package task3;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task3 {

    void findTheShortestDistanceFromFile(String filePath) {
        List<String> lines = readFile(filePath);
        findTheShortestDistance(lines.get(0), lines.get(1));
    }

    private List<String> readFile(String filePath) {
        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    void findTheShortestDistance(String firstLine, String secondLine) {
        Set<Point> coordinatesL1 = calculateCoordinates(firstLine);
        Set<Point> coordinatesL2 = calculateCoordinates(secondLine);

        Collection<Point> commonPoints = CollectionUtils.intersection(coordinatesL1, coordinatesL2);

        Optional<Integer> result = commonPoints.stream()
                .map(Point::distance)
                .min(Integer::compareTo);

        System.out.println(result);
    }

    private Set<Point> calculateCoordinates(String line) {
        Set<Point> coordinates = new HashSet<>();

        AtomicReference<Point> currentPoint = new AtomicReference<>(new Point(0, 0));

        String[] values = line.split(",");

        for (String l : values) {
            String operation = l.substring(0, 1);
            int steps = Integer.parseInt(l.substring(1));

            IntStream.range(0, steps)
                    .forEach(step -> {
                        currentPoint.set(calculatePoint(operation, currentPoint.get()));
                        coordinates.add(currentPoint.get());
                    });
        }
        return coordinates;
    }

    private Point calculatePoint(String operation, Point startPoint) {
        switch (operation) {
            case "R":
                return new Point(startPoint.x + 1, startPoint.y);
            case "L":
                return new Point(startPoint.x - 1, startPoint.y);
            case "U":
                return new Point(startPoint.x, startPoint.y + 1);
            case "D":
                return new Point(startPoint.x, startPoint.y - 1);
        }

        throw new UnsupportedOperationException();
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int distance() {
            return Math.abs(x) + Math.abs(y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


}
