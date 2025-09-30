class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {

    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        if (previous == null) {
            System.out.println("Error: previous node is null");
            return;
        }
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count++;
        }

        return current;
    }

    //  MÉTODO deleteAt 
    public Node deleteAt(int index) {
        if (head == null) {
            System.out.println("Error: List is empty.");
            return null;
        }

        if (index == 0) {
            Node oldHead = head;
            head = head.next;
            oldHead.next = null;
            return head;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count++;
        }

        if (current != null) {
            previous.next = current.next;
            current.next = null;
        } else {
            System.out.println("Error: Invalid index. Index " + index + " is out of bounds.");
        }

        return head;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/");
    }
}


class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        System.out.println("Lista original:");
        list.printList();

        System.out.println("\n\nInsertando 71 después del nodo en índice 2 (valor 30):");
        Node previous = list.LinkedListLookUp(2);
        Node newNode = new Node(71);
        list.LinkedListInsertAfter(previous, newNode);
        list.printList();

        System.out.println("\n\nEliminando nodo en índice 3 (valor 71):");
        list.deleteAt(3);
        list.printList();

        System.out.println("\n\nEliminando nodo en índice 0 (cabeza, valor 10):");
        list.deleteAt(0);
        list.printList();

        System.out.println("\n\nIntentando eliminar en índice 10 (índice inválido):");
        list.deleteAt(10);
        list.printList();

        System.out.println("\n\nIntentando eliminar de una lista vacía:");
        // Vaciamos la lista
        while (list.LinkedListLookUp(0) != null) {
            list.deleteAt(0);
        }
        list.deleteAt(0); // Debería decir "List is empty"
        list.printList();
    }
}