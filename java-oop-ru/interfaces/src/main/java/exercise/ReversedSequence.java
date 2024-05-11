package exercise;

// BEGIN
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReversedSequence implements CharSequence {

    private List<Character> chars;

    public ReversedSequence(String line) {
        this.chars = new ArrayList<>();

        for (var i = line.length() - 1; i >= 0; i--) {
            this.chars.add(line.charAt(i));
        }
    }

    @Override
    public int length() {
        return this.chars.size();
    }

    @Override
    public char charAt(int index) {
        return this.chars.get(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return chars.subList(start, end).stream()
            .map(Object::toString)
            .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return this.chars.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
    }
}
// END
