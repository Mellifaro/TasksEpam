package hundreddoors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {
    private static String word = "biro";

    public static void main(String[] args) {
        printAnagrams();
    }

    private static void printAnagrams(){
        List<Character> chars = word.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        List<String> anagrams = getAllCombinationsFromChars(chars);
        System.out.println(anagrams);
    }

    private static List<String> getAllCombinationsFromChars(List<Character> chars) {
        if(chars.size() == 1){
            return Collections.singletonList("" + chars.get(0));
        }

        List<String> partStrings = new ArrayList<>();
        for(int i = 0; i < chars.size(); i++){
            char currentChar = chars.get(i);
            boolean charIsFound = false;
            List<Character> characterList = new ArrayList<>();

            for(char c: chars){
                if(c != currentChar){
                    characterList.add(c);
                }
                if(c == currentChar && charIsFound){
                    characterList.add(c);
                }
                if(c == currentChar && !charIsFound){
                    charIsFound = true;
                }
            }

            List<String> shorterStrings = getAllCombinationsFromChars(characterList);
            shorterStrings.forEach(shortString -> partStrings.add(currentChar + shortString));
        }
        return partStrings;
    }
}
