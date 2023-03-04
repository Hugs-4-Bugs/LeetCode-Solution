class Solution {
    public int compress(char[] chars) {
    int n = chars.length;
    int i = 0; // index for the current character in chars
    int j = 0; // index for the current position to write the compressed character in chars
    
    while (i < n) {
        char c = chars[i];
        int count = 0; // count of consecutive repeating characters
        while (i < n && chars[i] == c) {
            i++;
            count++;
        }
        
        // write the compressed character to chars
        chars[j++] = c;
        if (count > 1) {
            String s = Integer.toString(count);
            for (int k = 0; k < s.length(); k++) {
                chars[j++] = s.charAt(k);
            }
        }
    }
    
    return j; // length of the compressed array
    }
}
