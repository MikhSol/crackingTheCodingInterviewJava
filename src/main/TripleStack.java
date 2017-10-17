package main;

import java.util.EmptyStackException;

class TripleStack {
    private final int numberOfStacks = 3;
    private int capacity;
    private int[] sizes;
    private int[] values;

    TripleStack(int c) {
        capacity = c;
        sizes = new int[numberOfStacks];
        values = new int[numberOfStacks * capacity];
    }

    int getNumberOfStacks() {
        return numberOfStacks;
    }

    int getCapacity() {
        return capacity;
    }

    int pop(int stackNumber) throws EmptyStackException {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
        int topIdx = indexOfTop(stackNumber);
        int value = values[topIdx];
        values[topIdx] = 0;
        sizes[stackNumber]--;
        return value;
    }

    boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }

    void push(int value, int stackNumber) throws StackOverflowError {
        if (isFull(stackNumber)) {
            throw new StackOverflowError("Stack is full.");
        }
        sizes[stackNumber]++;
        values[indexOfTop(stackNumber)] = value;
    }

    boolean isFull(int stackNumber) {
        return sizes[stackNumber] >= capacity;
    }

    private int indexOfTop(int stackNumber) {
        int offset = stackNumber * capacity;
        int size = sizes[stackNumber];
        return offset + size - 1;
    }

    int peek(int stackNumber) throws EmptyStackException {
        if (isEmpty(stackNumber)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNumber)];
    }
}
