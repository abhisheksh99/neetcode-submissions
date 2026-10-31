class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Create array of cars with position and speed
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new double[]{position[i], speed[i]};
        }
        
        // Sort cars by position in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        Stack<Double> stack = new Stack<>();
        // Calculate arrival time for each car
        for (double[] car : cars) {
            double arrivalTime = (target - car[0]) / car[1];
            // If stack is empty or current car arrives later than the last fleet
            if (stack.isEmpty() || arrivalTime > stack.peek()) {
                stack.push(arrivalTime);
            }
        }
        
        return stack.size();
    }
}