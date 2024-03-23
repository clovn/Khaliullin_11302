package ControlWork1_Var2;
//Variant 2
public class Main {
    public static void main(String[] args) {
        Dictionary a = new Dictionary("English");
        a.insert("cтул", "chair");
        a.insert("кошка", "cat");
        a.insert("дом", "house");
        a.insert("машина", "car");
        a.insert("книга", "book");
        a.insert("яблоко", "apple");
        a.insert("собака", "dog");
        a.insert("стол", "table");
        a.insert("компьютер", "computer");
        a.insert("окно", "window");
        a.insert("банка", "can");
        a.insert("банка", "bank");
        a.insert("банка", "tin");
        a.insert("банка", "jar");

        a.insert("лук", "onion");
        a.insert("лук", "bow");
        a.insert("лук", "leek");

        a.insert("замок", "lock");
        a.insert("замок", "castle");
        a.insert("замок", "palace");
        a.show();
        System.out.println(a.translate("лук замок банка"));
    }
}
