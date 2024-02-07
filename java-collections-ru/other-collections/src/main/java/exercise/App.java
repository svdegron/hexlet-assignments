package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        final String added = "added";
        final String deleted = "deleted";
        final String changed = "changed";
        final String unchanged = "unchanged";

        var result = new LinkedHashMap<String, String>();

        Set<String> temps = new TreeSet<>(data1.keySet());
        temps.addAll(data2.keySet());

        for (var key : temps) {
            String action = "action";
            if (data1.get(key) == data2.get(key)) {
                action = unchanged;
            } else if (data1.get(key) == null) {
                action = added;
            } else if (data2.get(key) != null) {
                action = changed;
            } else if (data1.containsKey(key) && data2.get(key) == null) {
                action = deleted;
            }

            result.put(key, action);
        }

        return result;
    }
}
//END
