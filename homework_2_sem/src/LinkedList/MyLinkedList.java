package LinkedList;

public class MyLinkedList {
    Node head;

    public MyLinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void add(int data, int index) {
        if (index < 0) {
            System.out.println("Индекс должен быть неотрицательным числом");
            return;
        }
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Индекс выходит за пределы списка");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void remove(int data){
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void removeByIndex(int index) {
        if (index < 0 || head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    public int get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new IndexOutOfBoundsException("Индекс выходит за пределы списка");
            }
            current = current.next;
        }
        return current.data;
    }

    public void sort() {
        if (head == null || head.next == null)
            return;

        Node current = head;
        Node index = null;
        int temp;

        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = head;
        while (current != null) {
            res.append(current.data).append(" ");
            current = current.next;
        }
        return res.toString();
    }

    public void removeFirst(int x){
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                remove(x);
                break;
            }
            current = current.next;
        }
    }

    public void removeAll(int x){
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                remove(x);
            }
            current = current.next;
        }
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}