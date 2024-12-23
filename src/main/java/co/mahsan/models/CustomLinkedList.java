package co.mahsan.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CustomLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void remove(T data) {
        if (isEmpty()) return;

        if (head.data.equals(data)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T removedData;

        if (index == 0) {
            removedData = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;

            if (current.next == tail) {
                tail = current;
                tail.next = null;
            } else {
                current.next = current.next.next;
            }
        }
        size--;
        return removedData;
    }

    public boolean removeIf(Predicate<T> predicate) {
        boolean removed = false;
        while (head != null && predicate.test(head.data)) {
            head = head.next;
            size--;
            removed = true;
        }

        if (head == null) {
            tail = null;
            return removed;
        }

        Node current = head;
        while (current.next != null) {
            if (predicate.test(current.next.data)) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                size--;
                removed = true;
            } else {
                current = current.next;
            }
        }
        return removed;
    }

    public int indexOf(T data) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (data.equals(current.data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public Stream<T> stream() {
        return toList().stream();
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current.next != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(current.data).append("]");
        return sb.toString();
    }
}