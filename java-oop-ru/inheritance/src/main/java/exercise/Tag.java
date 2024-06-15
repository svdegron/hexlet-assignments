package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String name;
    private Map<String, String> attributes;

    public Tag(String name, Map<String, String> attrs) {
        this.name = name;
        this.attributes = attrs;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return attributes.keySet().stream()
            .map(key -> " " + key + "=\"" + attributes.get(key) + "\"")
            .collect(Collectors.joining("", "<" + this.name, ">"));
    }
}
// END
