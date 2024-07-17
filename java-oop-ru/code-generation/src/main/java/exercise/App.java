package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        try {
            Files.writeString(path, car.serialize());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        Car extractCar = null;

        try {
            String content = Files.readString(path);
            extractCar = Car.unserialize(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return extractCar;
    }
}
// END
