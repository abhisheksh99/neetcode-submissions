public class MyCircularQueue {
    private List<Integer> queue;
    private int capacity;

    public MyCircularQueue(int k) {
        queue = new ArrayList<>();
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (queue.size() == capacity) {
            return false;
        }
        queue.add(value);
        return true;
    }

    public boolean deQueue() {
        if (queue.isEmpty()) {
            return false;
        }
        queue.remove(0);
        return true;
    }

    public int Front() {
        return queue.isEmpty() ? -1 : queue.get(0);
    }

    public int Rear() {
        return queue.isEmpty() ? -1 : queue.get(queue.size() - 1);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() == capacity;
    }
}