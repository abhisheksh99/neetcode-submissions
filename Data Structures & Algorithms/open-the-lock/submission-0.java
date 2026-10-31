

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (String next : getNextStates(curr)) {
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        if (next.equals(target)) return moves;
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getNextStates(String state) {
        List<String> nextStates = new ArrayList<>();
        char[] arr = state.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = arr[i];

            // turn wheel forward
            arr[i] = original == '9' ? '0' : (char)(original + 1);
            nextStates.add(new String(arr));

            // turn wheel backward
            arr[i] = original == '0' ? '9' : (char)(original - 1);
            nextStates.add(new String(arr));

            // restore original
            arr[i] = original;
        }
        return nextStates;
    }
}
