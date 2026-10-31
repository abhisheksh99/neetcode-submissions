class MinStack {
    private Node head; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    public MinStack() {
        // Stack starts as empty, so head is null
    }

    // Push a new value onto the stack
    public void push(int val) {
        if (head == null) {
            // If the stack is empty, create a new node as the head
            head = new Node(val, val, null);
        } else {
            // Add a new node to the top of the stack
            // Update the min value to be the smaller of the current value and the previous min
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    // Remove the top element from the stack
    public void pop() {
        if (head != null) {
            head = head.next; // Move the head pointer to the next node
        }
    }

    // Get the value of the top element
    public int top() {
        return head.val; // Return the value of the top node
    }

    // Get the minimum value in the stack
    public int getMin() {
        return head.min; // Return the minimum value stored in the top node
    }

    // Inner class to represent a node in the stack
    private class Node {
        int val; // The value of the node
        int min; // The minimum value in the stack up to this node
        Node next; // Reference to the next node in the stack

        // Constructor to initialize the node
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
