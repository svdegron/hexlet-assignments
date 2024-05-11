package exercise;

// BEGIN
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int countElements) {
        if (homes.isEmpty()) {
            return new ArrayList<>();
        }

        return homes.stream()
            .sorted(Comparator.comparingDouble(Home::getArea))
            .map(Home::toString)
            .toList()
            .subList(0, countElements);
    }
}
// END
