package com.github.seijuro.common.util;

import java.util.Objects;

public class CircularList<T> {
    public class Element {
        T value;
        Element next;

        public Element(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private int size = 0;
    private Element head, nil;
    private Element current;

    public CircularList() {
        head = null;
        nil = null;
        current = null;
    }

    public int size() { return size; }

    public T getNext() {
        if (Objects.isNull(current)) {
            current = head;
        }
        else {
            current = current.next;
        }

        if (Objects.isNull(current)) {
            current = head;
        }

        if (Objects.nonNull(current)) {
            return current.value;
        }
        else {
            return null;
        }
    }

    public void insert(T value) {
        if (head == null) {
            Element element = new Element(value);
            head = element;
            nil = element;
        }
        else {
            Element element = new Element(value);
            Element lastElement = nil;
            nil = element;
            lastElement.next = nil;
        }

        ++size;
    }

    public void delete(T value) {
        Element tmp1 = head;
        Element tmp2 = null;

        while (Objects.nonNull(tmp1)) {
            if (tmp1.value.equals(value)) {
                if (Objects.isNull(tmp2)) {
                    head = tmp1.next;
                }
                else {
                    tmp2.next = tmp1.next;
                }

                --size;
                break;
            }

            tmp2 = tmp1;
            tmp1 = tmp1.next;
        }
    }
}
