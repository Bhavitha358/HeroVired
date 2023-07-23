class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void mergeAndSort(LinkedList list1, LinkedList list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                add(current1.data);
                current1 = current1.next;
            } else {
                add(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            add(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            add(current2.data);
            current2 = current2.next;
        }
    }

    public void bubbleSort() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node ptr1;
        Node lptr = null;

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class MergeAndSortLinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(25);
        list1.add(35);
        list1.add(12);
        list1.add(4);
        list1.add(36);
        list1.add(48);

        LinkedList list2 = new LinkedList();
        list2.add(8);
        list2.add(32);
        list2.add(22);
        list2.add(45);
        list2.add(63);
        list2.add(49);

        LinkedList mergedList = new LinkedList();
        mergedList.mergeAndSort(list1, list2);

        System.out.println("Merged and Sorted Linked List: ");
        mergedList.bubbleSort();
        mergedList.display();
    }
}
