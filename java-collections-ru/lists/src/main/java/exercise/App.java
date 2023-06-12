package exercise;

//import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        if (word.length() > symbols.length()) {
            return false;
        }

        List<Character> listWord = new ArrayList<>();
        List<Character> listSymbol = new ArrayList<>();

        for (char ch: word.toCharArray()) {
            listWord.add(Character.toLowerCase(ch));
        }

        for (char ch: symbols.toCharArray()) {
            listSymbol.add(Character.toLowerCase(ch));
        }

        for (Character symbol: listWord) {
            if (listSymbol.indexOf(symbol) == -1) {
                return false;
            } else {
                listSymbol.remove(symbol);
            }
        }

        return true;
    }
}
//END
