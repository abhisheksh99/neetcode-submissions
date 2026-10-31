class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length]; // Result array to store the number of days to wait for a warmer temperature
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of temperatures

        // Iterate through the temperatures array
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i]; // Current temperature
            
            // While the stack is not empty and the current temperature is greater than the temperature at the index stored in the stack
            while (!stack.isEmpty() && t > temperatures[stack.peek()]) {
                int index = stack.pop(); // Pop the index from the stack
                res[index] = i - index; // Calculate the difference in days and store it in the result array
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        return res; // Return the result array
    }
}
