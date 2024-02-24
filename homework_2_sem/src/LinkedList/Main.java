package LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyLinkedList a = enterSortedArray(10);
        System.out.println(a);
        removeTwo(a);
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

    public static MyLinkedList enterSortedArray(int count){
        MyLinkedList list = new MyLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы списка:");

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            list.addSorted(num);
        }

        return list;
    }

    public static void removeTwo(MyLinkedList list){
        for(int i = 0; i < 2; i++){
            list.removeByIndex(0);
        }
    }
}
