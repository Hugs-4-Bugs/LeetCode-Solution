class Solution {
    public String answerString(String word, int numFriends) {
        // If only one friend, return the whole word as the only possible split
        if (numFriends == 1) {
            return word;
        }

        char maxC = 'a';  // Variable to store the current maximum character
        List<Integer> startIdx = new ArrayList<>();  // List to store starting indices of max characters
        
        // Iterate through the word to find the maximum character and its positions
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c > maxC) {
                startIdx.clear();
                maxC = c;
            }
            if (c == maxC) {
                startIdx.add(i);
            }
        }

        String ans = "";  // Variable to store the final answer
        // Iterate over each starting index and calculate the lexicographically largest substring
        for (int i : startIdx) {
            // Calculate the valid endIdx for the substring
            int endIdx = word.length() - (numFriends - 1) + i;
            // Ensure endIdx is within bounds
            if (endIdx > word.length()) {
                endIdx = word.length();
            }

            ans = (ans.compareTo(word.substring(i, endIdx)) < 0) ? word.substring(i, endIdx) : ans;
        }

        return ans;  // Return the lexicographically largest string
    }
}
