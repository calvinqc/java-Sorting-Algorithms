package InsertionSort;

public class insertionSort extends DoublyLinkedList {
    private DoublyLinkedList list;

    public insertionSort() {
        list = new DoublyLinkedList();
    }

    /**
     * Returns the result of sorting the values in this list using the insertion
     * sort algorithm. This list is no longer usable after this operation; you
     * have to use the returned list.
     */
    public DoublyLinkedList sort() {
        Node soFar = null;
        for (Node p = list.getHead(); p != null; p = p.next) {
            soFar = insert(p, soFar);
        }
        return new DoublyLinkedList(soFar);
    }

    /**
     * Inserts the node p into the list headed by head so that the node values
     * are in increasing order.
     */
    private Node insert(Node p, Node head) {
        Node curr = head;
        if (head == null) {
            return new Node(p.item);
        }
        if (p.item < head.item) {
            head.prev = new Node(p.item, head,null);
            head = head.prev;
            return head;
        }

        while (curr.next != null && curr.next.item < p.item) {
            curr = curr.next;
        }
        if (curr.next == null) {
            curr.next = new Node(p.item, null, curr);
            return head;
        }
        Node newNode = new Node(p.item, curr.next, curr);
        curr.next = newNode;
        curr.next.prev = newNode;
        return head;
    }

    public DoublyLinkedList getList() {
        return list;
    }
}
