class Solution {
    public boolean isValid(String s) {
        // Map to store matching brackets: closing brackets as keys and opening brackets as values
        HashMap<Character, Character> mappedBrackets = new HashMap<>();
        mappedBrackets.put(')', '(');
        mappedBrackets.put('}', '{');
        mappedBrackets.put(']', '[');

        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through the string character by character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Get the current character

            // If the character is a closing bracket
            if (mappedBrackets.containsKey(c)) {
                // If the stack is empty, no matching opening bracket exists
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack
                char topElement = stack.pop();

                // Check if the popped element matches the corresponding opening bracket
                if (topElement != mappedBrackets.get(c)) {
                    return false;
                }
            } 
            // If the character is an opening bracket, push it onto the stack
            else {
                stack.push(c);
            }
        }

        // If the stack is empty at the end, all brackets are balanced
        return stack.isEmpty();
    }
}