package exercise;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Path filepath;

    public FileKV(String path, Map<String, String> map) {
        this.filepath = Paths.get(path).toAbsolutePath().normalize();

        var stringData = dataToString(map);
        saveStringData(stringData);
    }

    private void saveStringData(String str) {
        Utils.writeFile(getStingPath(), str);
    }

    private String dataToString(Map<String, String> map) {
        return Utils.serialize(map);
    }

    private Map<String, String> stringToData(String str) {
        return Utils.unserialize(str);
    }

    private String getStringData() {
        return Utils.readFile(getStingPath());
    }

    private String getStingPath() {
        return this.filepath.toString();
    }

    @Override
    public void set(String key, String value) {
        var stringData = getStringData();
        Map<String, String> data = new HashMap<>();

        data.putAll(stringToData(stringData));
        data.put(key, value);

        stringData = dataToString(data);

        saveStringData(stringData);
    }

    @Override
    public void unset(String key) {
        var stringData = getStringData();
        Map<String, String> data = new HashMap<>();

        data.putAll(stringToData(stringData));
        data.remove(key);

        stringData = dataToString(data);

        saveStringData(stringData);
    }

    @Override
    public String get(String key, String defaultValue) {
        var stringData = getStringData();
        Map<String, String> data = new HashMap<>();

        data.putAll(stringToData(stringData));

        if (data.containsKey(key)) {
            return data.get(key);
        }

        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        var stringData = getStringData();
        Map<String, String> data = new HashMap<>();

        data.putAll(stringToData(stringData));

        return data.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
// END
