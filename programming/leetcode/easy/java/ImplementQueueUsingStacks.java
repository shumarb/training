class MyQueue {
    private Stack<Integer> stack;
    private Stack<Integer> stackHelper;

    public MyQueue() {
        stack = new Stack<> ();
        stackHelper = new Stack<> ();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        reducesStackToLastElement();
        int toRemove = stack.peek();
        stack.pop();
        populatesStack();
        return toRemove;
    }

    public int peek() {
        reducesStackToLastElement();
        int firstElementInQueue = stack.peek();
        stack.pop();
        stackHelper.push(firstElementInQueue);
        populatesStack();
        return firstElementInQueue;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    private void reducesStackToLastElement() {
        while (!stack.isEmpty() && stack.size() != 1) {
            stackHelper.push(stack.peek());
            stack.pop();
        }
    }

    private void populatesStack() {
        while (!stackHelper.isEmpty()) {
            stack.push(stackHelper.peek());
            stackHelper.pop();
        }
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */