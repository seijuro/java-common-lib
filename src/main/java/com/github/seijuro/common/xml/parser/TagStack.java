package com.github.seijuro.common.xml.parser;

import java.util.LinkedList;

public class TagStack<T> extends LinkedList<T> {
    public int size() {
        return super.size();
    }

    public T pop() {
        return this.pollLast();
    }

    public void push(T element) {
        this.offerLast(element);
    }

    public T top() {
        return this.peekLast();
    }

    public boolean isTop(T element) {
        return element.equals(this.top());
    }
}
