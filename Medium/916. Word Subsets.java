import java.util.*;

public class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Create a map to store the frequency of characters in words2
        Map<Character, Integer> words2Freq = new HashMap<>();
        
        // Update the frequency map with the required frequency of each character in words2
        for (String word : words2) {
            Map<Character, Integer> tempFreq = new HashMap<>();
            for (char c : word.toCharArray()) {
                tempFreq.put(c, tempFreq.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : tempFreq.entrySet()) {
                words2Freq.put(entry.getKey(), Math.max(words2Freq.getOrDefault(entry.getKey(), 0), entry.getValue()));
            }
        }

        List<String> result = new ArrayList<>();

        // Check each word in words1
        for (String word : words1) {
            Map<Character, Integer> wordFreq = new HashMap<>();
            for (char c : word.toCharArray()) {
                wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
            }

            boolean isValid = true;
            // Check if word contains all characters in words2 with the required frequency
            for (Map.Entry<Character, Integer> entry : words2Freq.entrySet()) {
                char key = entry.getKey();
                int requiredFreq = entry.getValue();
                if (wordFreq.getOrDefault(key, 0) < requiredFreq) {
                    isValid = false;
                    break;
                }
            }

            // If valid, add the word to the result
            if (isValid) {
                result.add(word);
            }
        }

        return result;
    }

    
}