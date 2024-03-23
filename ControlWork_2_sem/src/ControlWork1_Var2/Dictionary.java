package ControlWork1_Var2;
//Variant 2
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private String dictionaryLang;
    private Node head;
    private int size = 0;

    public Dictionary(String lang){
        dictionaryLang = lang;
    }

    public void show(){
        Node current = head;
        System.out.println(dictionaryLang + " Dictionary:");
        while (current != null) {
            System.out.println(current.source + " - " + current.translate);
            current = current.next;
        }
    }

    public void insert(String source, String newTranslate){
        Node newNode = new Node(source, newTranslate);
        size++;

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

    public void delete(String k){
        if (head == null) {
            return;
        }

        while (head != null && head.source.equals(k)) {
            head = head.next;
            size--;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.source.equals(k)) {
                previous.next = current.next;
                size--;
            } else {
                previous = current;
            }
            current = current.next;
        }
    }

    public Set<String> unique(){
       Set<String> unique = new HashSet<>();
       Set<String> nonUnique = new HashSet<>();

        if(head == null){
            return unique;
        }

        Node current = head;

        while (current.next != null){
            if(unique.contains(current.source)){
                nonUnique.add(current.source);
                unique.remove(current.source);
            } else if(!nonUnique.contains(current.source)) {
                unique.add(current.source);
            }
            current = current.next;
        }

        return unique;
    }

    public int numLen1(){
        int count = 0;

        Node current = head;

        while (current != null){

            if(Math.abs(current.source.length() - current.translate.length()) <= 1){
                count++;
            }

            current = current.next;
        }

        return count;
    }

    public String getTranslate(String source){
        if(head == null) return source;

        Node current = head;

        while (current != null){
            if(current.source.equals(source)){
                return current.translate;
            }

            current = current.next;
        }

        return source;
    }

    public String translate(String text){

        StringBuilder translatedText = new StringBuilder();

        for(String word : text.split(" ")){
            translatedText.append(getTranslate(word)).append(" ");
        }

        return translatedText.toString();
    }
}

class Node {
    String source;
    String translate;
    Node next;

    public Node(String source, String translate) {
        this.source = source;
        this.translate = translate;
        this.next = null;
    }
}