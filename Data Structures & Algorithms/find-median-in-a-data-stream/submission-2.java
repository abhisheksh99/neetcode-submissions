public class MedianFinder {

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> b - a);  // max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>();  // min heap

    // Adds a number into the data structure.
    public void addNum(int num) {
        lo.offer(num);  // Add to max heap

        hi.offer(lo.poll());  // balancing step

        if (lo.size() < hi.size()) {  // maintain size property
            lo.offer(hi.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}