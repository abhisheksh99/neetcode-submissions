class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // handle multi-digit numbers
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(current.toString());
                current = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int count = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }
                current = temp;
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }
}