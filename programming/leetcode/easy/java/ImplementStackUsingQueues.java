class MyStack {
    private Queue<Integer> queue;
    private Queue<Integer> queueHelper;
    private int topElement;

    public MyStack() {
        queue = new LinkedList<> ();
        queueHelper = new LinkedList<> ();
    }

    private void reducesQueueToLastElement() {
        while (queue.size() != 1) {
            queueHelper.offer(queue.peek());
            queue.poll();
        }
    }

    private void populatesQueue() {
        while (!queueHelper.isEmpty()) {
            queue.offer(queueHelper.peek());
            queueHelper.poll();
        }
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        reducesQueueToLastElement();
        topElement = queue.peek();
        queue.poll();
        populatesQueue();
        return topElement;
    }

    public int top() {
        reducesQueueToLastElement();
        topElement = queue.peek();
        queue.poll();
        queueHelper.offer(topElement);
        populatesQueue();
        return topElement;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
