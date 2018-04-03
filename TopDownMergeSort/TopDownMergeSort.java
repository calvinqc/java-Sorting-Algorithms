package TopDownMergeSort;
import DoublyLinkedList.*;

public class TopDownMergeSort extends DoublyLinkedList {

    private DoublyLinkedList list;
    private int size;

    public TopDownMergeSort() {
        list = new DoublyLinkedList();
        size = list.getSize();
    }

    /**
     * Returns the result of sorting the values in this list using the merge
     * sort algorithm. This list is no longer usable after this operation.
     */
    public DoublyLinkedList sort(DoublyLinkedList list) {
        if (size <= 1) {
            return list;
        }
        DoublyLinkedList oneHalf = new DoublyLinkedList();
        DoublyLinkedList otherHalf = new DoublyLinkedList();

        for (int i = 0; i < list.getSize() / 2; i++) {
            oneHalf.addToEnd(list.getHead().item);
            setHead(list.getHead().next);
        }
        for (int i = this.size / 2 + 1; i <= this.size; i++) {
            otherHalf.addToEnd(list.getHead().item);
            setHead(list.getHead().next);
        }
        return merge(sort(oneHalf).getHead(), sort(otherHalf).getHead());
    }

    /**
     * Returns the result of merging the two sorted lists / represented by list1
     * and list2.
     */
    private static DoublyLinkedList merge(Node list1, Node list2) {
        DoublyLinkedList rtn = new DoublyLinkedList();
        while (list1 != null && list2 != null) {
            if (list1.item < list2.item) {
                rtn.addToEnd(list1.item);
                list1 = list1.next;
            } else {
                rtn.addToEnd(list2.item);
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            rtn.addToEnd(list1.item);
            list1 = list1.next;
        }
        while (list2 != null) {
            rtn.addToEnd(list2.item);
            list2 = list2.next;
        }
        return rtn;
    }
    public DoublyLinkedList getList() {
        return list;
    }

    public void setList(DoublyLinkedList list) {
        this.list = list;
    }
}
