class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();
                int currSize = Math.abs(ast);

                if (top < currSize) {          // top is smaller → destroyed
                    stack.pop();
                    continue;                  // keep checking with new top
                } else if (top == currSize) {  // same size → both destroyed
                    stack.pop();
                }
                ast = 0;                       // current asteroid destroyed
                break;
            }
            if (ast != 0) {
                stack.push(ast);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
