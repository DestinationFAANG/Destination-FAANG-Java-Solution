// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Leetcode Link: https://leetcode.com/problems/design-circular-queue/
//Youtube Link: https://www.youtube.com/watch?v=-MsZSmFGS4E


**************** Java Solution ***********************



class MyCircularQueue {
    private final int[] data;
    private final int cap;
    private int head;
    private int size;

    // Constructor
    public MyCircularQueue(int k) {
        data = new int[k];
        cap = k;
        head = 0;
        size = 0;
    }

    // Insert at rear
    public boolean enQueue(int value) {
        if (isFull()) return false;
        int tail = (head + size) % cap;
        data[tail] = value;
        size++;
        return true;
    }

    // Remove from front
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % cap;
        size--;
        return true;
    }

    // Get front element
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    // Get rear element
    public int Rear() {
        if (isEmpty()) return -1;
        int tail = (head + size - 1) % cap;
        return data[tail];
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check full
    public boolean isFull() {
        return size == cap;
    }
}
