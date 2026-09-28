// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.*;


class Main {
    public static List<Integer> findDuplicates(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }
        Set<Integer> duplicates = new LinkedHashSet<>();
        Set<Integer> seen = new LinkedHashSet<>();
        for(Integer num: numbers) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return new ArrayList<>(duplicates);
    }
    
    public static Character firstNonRepeatingChar(String input)  {
        if (input == null || input.isEmpty()) {
            return null;
        }
        Map<Character, Integer> hm = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static Map<String, Integer> frequency(List<String> words) {
        Map<String, Integer> hm = new HashMap<>();
        if (words == null || words.isEmpty()) {
            return hm;
        }
        for(String word: words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1); 
        }
        return hm;
    }
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("swiss"));
        System.out.println(firstNonRepeatingChar("shreya"));
        // ------------------------------
        List<Integer> numbers =
        Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6, 3, 3);
        System.out.println(findDuplicates(numbers));

        // ----------------------------------------

        List<String> words = Arrays.asList(
            "java", "spring", "java",
            "kafka", "spring", "java"
        );
        System.out.println(frequency(words));

        // ---------------------------------
    }
}