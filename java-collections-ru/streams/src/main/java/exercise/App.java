package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static Long getCountOfFreeEmails(List<String> emails) {
        var freeDomain = List.of("gmail.com", "yandex.ru", "hotmail.com");
        return emails
                .stream()
                .map(email -> email.split("@")[1])
                .filter(freeDomain::contains)
                .count();
    }
}
// END
