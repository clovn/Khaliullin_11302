package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList a = enterArray(10);
        System.out.println(a);
        insertAfterAll(a, 2, 200);
        System.out.println(a);
    }

    public static MyLinkedList enterArray(int count){
        MyLinkedList list = new MyLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы списка:");

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            list.add(num);
        }

        return list;
    }

    public static int getMax(MyLinkedList list){
        int max = list.head.data;
        Node current = list.head;

        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }

    public static boolean find(MyLinkedList list ,int x){
        Node current = list.head;
        while (current != null) {
            if (current.data == x) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void insertAfterFirst(MyLinkedList list, int x, int y){
        Node current = list.head;
        int count = 0;
        while (current != null) {
            if (current.data == x) {
                list.add(y, count+1);
                return;
            }
            current = current.next;
            count++;
        }
    }

    public static void insertBeforeFirst(MyLinkedList list, int x, int y){
        Node current = list.head;
        int count = 0;
        while (current != null) {
            if (current.data == x) {
                list.add(y, count);
                return;
            }
            current = current.next;
            count++;
        }
    }

    public static void insertAfterAll(MyLinkedList list, int x, int y){
        Node current = list.head;
        int count = 0;
        while (current != null) {
            if (current.data == x) {
                list.add(y, count+1);
            }
            current = current.next;
            count++;
        }
    }
}
