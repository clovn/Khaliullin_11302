package hw3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        List<List<Integer>> lists = List.of(
//                List.of(1, 2, 3),
//                List.of(4, 5, 6),
//                List.of(7, 8, 9)
//        );
//
//        System.out.println(new Stream<>(lists).flatMap(Stream<Integer>::new).peek(System.out::println).count());

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", "Иван", 43));
        students.add(new Student("Петров", "Петр", 92));
        students.add(new Student("Сидорова", "Мария", 36));
        students.add(new Student("Смирнов", "Алексей", 65));
        students.add(new Student("Козлова", "Ольга", 56));
        students.add(new Student("Новиков", "Дмитрий", 75));
        students.add(new Student("Лебедева", "Екатерина", 88));
        students.add(new Student("Морозов", "Артем", 94));
        students.add(new Student("Волков", "Владимир", 37));
        students.add(new Student("Зайцева", "Анастасия", 97));

        //16
        new Stream<>(students)
                .filter(n -> n.points >= 56)
                .forEach(n -> System.out.println(n.surname + " " + n.name));

        //17
        System.out.println(new Stream<>(students)
                .filter(n -> n.points >= 56)
                .mapToInt(n -> n.points)
                .avg());
    }
}