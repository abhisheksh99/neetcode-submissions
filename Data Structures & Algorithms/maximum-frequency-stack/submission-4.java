class FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        if (!group.containsKey(freq)) {
            group.put(freq, new Stack<>());
        }
        group.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> stack = group.get(maxFreq);
        int val = stack.pop();
        freqMap.put(val, freqMap.get(val) - 1);
        if (stack.isEmpty()) {
            group.remove(maxFreq);
            maxFreq--;
        }
        return val;
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */