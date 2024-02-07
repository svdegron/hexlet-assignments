package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        final String ADDED = "added";
        final String DELETED = "deleted";
        final String CHANGED = "changed";
        final String UNCHANGED = "unchanged";

        var result = new LinkedHashMap<String, String>();

        Set<String> temps = new TreeSet<>(data1.keySet());
        temps.addAll(data2.keySet());

        for (var key : temps) {
            String action = "action";
            if (data1.get(key) == data2.get(key)) {
                action = UNCHANGED;
            } else if (data1.get(key) == null) {
                action = ADDED;
            } else if (data2.get(key) != null) {
                action = CHANGED;
            } else if (data1.containsKey(key) && data2.get(key) == null) {
                action = DELETED;
            }

            result.put(key, action);
        }

        return result;
    }
}
//END
