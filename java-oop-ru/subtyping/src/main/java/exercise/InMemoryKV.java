package exercise;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> dictionary;

    public InMemoryKV(Map<String, String> map) {
        this.dictionary = new HashMap<>();
        this.dictionary.putAll(map);
    }

    @Override
    public void set(String key, String value) {
        dictionary.put(key, value);
    }

    @Override
    public void unset(String key) {
        if (dictionary.containsKey(key)) {
            dictionary.remove(key);
        }
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!dictionary.containsKey(key)) {
            return defaultValue;
        }

        return dictionary.get(key);
    }

    @Override
    public Map<String, String> toMap() {
        return dictionary.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
// END
