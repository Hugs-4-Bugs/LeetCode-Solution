import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;

        List<String> answer = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j & words[j].contains(words[i])){
                    answer.add(words[i]);
                    break;
                }
            }
        }
        return answer;
    }
}               


/*
list of substring =  [ "as", "hero" ]


[  0     1     2      3  ]                 // index
["mass","as","hero","superhero"]           // i'th index
 
       [  0     1     2      3  ] 
       ["mass","as","hero","superhero"]    // j'th index


here 'mass' at i=0 is not substring of 'mass' at j=0, coz substring should be small part of string.
here 'as' is not substring of 'mass' and 'as' because as is String and substring is chunk or small part of the string  
*/
