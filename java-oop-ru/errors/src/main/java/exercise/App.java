package exercise;

// BEGIN
public class App {
    public static void main(String[] args) {
        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 4);
        App.printSquare(circle);
        // => "50"
        // => "Вычисление окончено"

        Circle circle1 = new Circle(point, -2);
        App.printSquare(circle1);
        // => "Не удалось посчитать площадь"
        // => "Вычисление окончено"
    }

    public static void printSquare(Circle circle) {
        try {
            var square = circle.getSquare();

            if (square > 100) {
                System.out.println(String.format("%f", square));
            } else {
                System.out.println(String.format("%d", (int) Math.ceil(square)));
            }
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
