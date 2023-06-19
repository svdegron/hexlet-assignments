package exercise;
// 4 шт: list, map, arraylist, map.entry
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;
//
import java.util.HashMap;

// BEGIN
class App {

    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();

        Map<String, String> book1 = new HashMap<>(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book2 = new HashMap<>(
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        );
        Map<String, String> book3 = new HashMap<>(
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book4 = new HashMap<>(
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        );
        Map<String, String> book5 = new HashMap<>(
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        );

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map<String, String>> result = App.findWhere(books, where);

        System.out.println(result); // =>
// [
//     {title=Cymbeline, year=1611, author=Shakespeare},
//     {title=The Tempest, year=1611, author=Shakespeare}
// ]
// проблема с дублированием (1) решено в (2, 3)
// [
//      {title=Cymbeline, year=1611, author=Shakespeare},
//      {title=Cymbeline, year=1611, author=Shakespeare},
//      {title=The Tempest, year=1611, author=Shakespeare},
//      {title=The Tempest, year=1611, author=Shakespeare}
// ]
    }

    public static List<Map<String, String>> findWhere (List<Map<String, String>> books, Map<String, String> dictionary) {
        List<Map<String, String>> searchingResults = new ArrayList<>();

        for (Map<String, String> book: books) {
            int match = 0;

            for (String key: dictionary.keySet()) {
                if (book.get(key) == dictionary.get(key)) {
                    match++;
                }
            }

            if (match == dictionary.size()) {
                searchingResults.add(book);
            }
        }

        return searchingResults;
    }

    // убрал лишнее сравнение, тоже работает
    public static List<Map<String, String>> findWhere3 (List<Map<String, String>> books, Map<String, String> dictionary) {
        List<Map<String, String>> searchingResults = new ArrayList<>();

        for (Map<String, String> book: books) {
            int match = 0;

            for (String key: dictionary.keySet()) {
                if (book.get(key) == dictionary.get(key)) {
                    match++;
                }
            }

            if (match == dictionary.size()) {
                searchingResults.add(book);
            }
        }

        return searchingResults;
    }

    // рабочий метод
    public static List<Map<String, String>> findWhere2 (List<Map<String, String>> books, Map<String, String> dictionary) {
        List<Map<String, String>> searchingResults = new ArrayList<>();

        for (Map<String, String> book: books) {
            int match = 0;

            for (String key: dictionary.keySet()) {
                if (book.get(key) == dictionary.get(key)) {
                    match++;
                }
            }

            if (!searchingResults.contains(book) && match == dictionary.size()) {
                searchingResults.add(book);
            }
        }

        return searchingResults;
    }

    // пример проходит, тесты ломаются
    public static List<Map<String, String>> findWhere1(List<Map<String, String>> books, Map<String, String> dictionary) {
        List<Map<String, String>> searchingResults = new ArrayList<>();
        
        for (Map<String, String> book: books) {
            for (String key: dictionary.keySet()) {
                if (book.get(key) == dictionary.get(key) && !searchingResults.contains(book)) {
                    searchingResults.add(book);
                }
            }
        }
        
        return searchingResults;
    }
}
//END
