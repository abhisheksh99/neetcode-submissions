class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // Stack to evaluate the expression

        // Iterate through each token in the input array
        for (String c : tokens) {
            if (c.equals("+")) {
                // If the token is '+', pop the top two elements, add them, and push the result back onto the stack
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                // If the token is '-', pop the top two elements, subtract the second popped value from the first, and push the result
                int a = stack.pop(); // First operand (top of stack)
                int b = stack.pop(); // Second operand
                stack.push(b - a);
            } else if (c.equals("*")) {
                // If the token is '*', pop the top two elements, multiply them, and push the result back onto the stack
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                // If the token is '/', pop the top two elements, divide the second popped value by the first, and push the result
                int a = stack.pop(); // First operand (top of stack)
                int b = stack.pop(); // Second operand
                stack.push(b / a);
            } else {
                // If the token is a number, convert it to an integer and push it onto the stack
                stack.push(Integer.parseInt(c));
            }
        }
        // Return the final result from the top of the stack
        return stack.pop();
    }
}
