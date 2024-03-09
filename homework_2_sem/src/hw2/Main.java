package hw2;

import java.util.ArrayList;
import java.util.Comparator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
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
        students.stream()
                .filter(n -> n.points >= 56)
                .forEach(n -> System.out.println(n.surname + " " + n.name));

        //17
        System.out.println(students.stream()
                .filter(n -> n.points >= 56)
                .mapToDouble(n -> n.points)
                .average()
                .orElse(0));

        //18
        Student s = students.stream()
                .filter(n -> n.points >= 56)
                .max(Comparator.comparingInt(a -> a.surname.length())).orElse(new Student("", "", 1));
        System.out.println(s.surname);
    }
}