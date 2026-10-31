

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean alive = true;

            // Handle collisions only when current asteroid moves left (ast < 0)
            // and top of stack moves right (stack.peek() > 0)
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                if (Math.abs(ast) > stack.peek()) {
                    // Top asteroid is smaller → it explodes
                    stack.pop();
                    continue;
                } else if (Math.abs(ast) == stack.peek()) {
                    // Both explode
                    stack.pop();
                }
                // Current asteroid explodes
                alive = false;
                break;
            }

            // If current asteroid survives, push it to stack
            if (alive) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
