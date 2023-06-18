package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> words = new HashMap<>();
        String[] temp = sentence.split(" ");

        if (temp.length <= 1) {
            return words;
        }

        for (String word: temp) {
            if (!words.containsKey(word)) {
                words.put(word, 1);
            } else {
                words.replace(word, words.get(word) + 1);
            }
        }

        return words;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.size() == 0) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (String key: map.keySet()) {
            sb.append("  " + key + ": " + map.get(key) + "\n");
        }

        sb.append("}");

        return sb.toString();
    }
}
//END
