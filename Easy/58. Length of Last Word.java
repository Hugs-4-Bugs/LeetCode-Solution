class Solution {
    public int lengthOfLastWord(String s) {
        s  = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');
        String lastWord = s.substring(lastSpaceIndex + 1);
        return lastWord.length();
    }
}
