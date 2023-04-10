class Solution {
    public boolean isValid(String s) {
            if(s.length()%2 != 0) return false;
    
    Stack<Character> stack = new Stack<>();

    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);

        if(c == '{' || c == '(' || c == '[')
            stack.push(c);

        else if(!stack.empty()){
             if((c == ']' && stack.peek() == '[') ||(c == '}' && stack.peek() == '{') || (c == ')' && stack.peek() == '('))
                stack.pop();
            else
                stack.push(c);
        } 
        else stack.push(c);
    }

    if(stack.empty()) return true;
    else return false;
    }
}
