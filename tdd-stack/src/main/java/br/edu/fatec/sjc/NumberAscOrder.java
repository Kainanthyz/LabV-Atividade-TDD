package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private final CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack must not be null");
        }
        this.stack = stack;
    }

    public List<T> sort() {
        List<T> sortedList = new ArrayList<>();

        try {
            while (!stack.isEmpty()) {
                sortedList.add(stack.pop());
            }
        } catch (StackEmptyException e) {
            throw new RuntimeException("Unexpected empty stack during sort", e);
        }

        Collections.sort(sortedList);
        return sortedList;
    }
}
