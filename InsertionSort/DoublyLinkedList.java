/**
 * A doubly-linked list of integers supporting various sorting algorithms.
 * @author Calvin Nguyen
 */
public class DoublyLinkedList {

    /* The head of this IntList. */
    private Node head;
    /* The tail of this IntList. */
    private Node tail;
    /* The size or number of integers in this IntList. */
    private int size;

    /**
     * Constructs an empty Doubly Linked List
     */
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Constructs an Doubly Linked List with one node. Head and tail are the same.
     */
    public DoublyLinkedList(Node head) {
        this.head = this.tail = head;
        this.size = 1;
    }

    /**
     * Returns true if this list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a new node with the given value to the front of this list.
     */
    public void addToFront(int k) {
        if (head == null) {
            head = tail = new Node(k);
        } else {
            head = new Node(k, head, null);
            head.next.prev = head;
        }
        size++;
    }

    /**
     * Adds a new node with the given value to the end of this list.
     */
    public void addToEnd(int k) {
        if (head == null) {
            head = tail = new Node(k);
        } else {
            tail.next = new Node(k, null, tail);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Attaches the input list to the end of this list.
     */
    public void append(DoublyLinkedList list) {
        if (list.isEmpty()) {
            return;
        }
        if (isEmpty()) {
            head = list.head;
            tail = list.tail;
            size = list.size;
            return;
        }
        tail.next = list.head;
        list.head.prev = tail;
        tail = list.tail;
        size += list.size;
    }

    /**
     * Removes the node reference by p from this list.
     */
    private void remove(Node p) {
        if (head == tail) {
            head = tail = null;
        } else if (p == head) {
            head = head.next;
            head.prev = null;
        } else if (p == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            p.next.prev = p.prev;
            p.prev.next = p.next;
        }
        size--;
    }

    @Override
    public String toString() {
        String s = "";
        for (Node p = head; p != null; p = p.next) {
            s = s + p.item + " ";
        }
        return s;
    }

    private class Node {

        int item;
        Node prev;
        Node next;

        private Node(int k) {
            this.item = k;
            this.prev = this.next = null;
        }

        private Node(int k, Node next, Node prev) {
            this.item = k;
            this.prev = prev;
            this.next = next;
        }
    }
}