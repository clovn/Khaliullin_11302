package hw4;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class DOMTree {
    private Node root;
    Node currentNode;

    public DOMTree(){
    }

    public DOMTree(String url){
        parseHtml(url);
    }

    private void parseHtml(String url){
        try(Scanner in = new Scanner(new URL(url).openStream())) {
            int state = 0;
            String tmp = "";
            String tag = "";
            Node temp = null;
            Map<String, String> attr = new HashMap<>();
            boolean flag = true;
            while(in.hasNextLine() && flag){
                for(char i : in.nextLine().strip().toCharArray()){
                    if(state == 0){
                        if(i == '<') state = 1;
                        else {
                            flag = false;
                            break;
                        }
                    }
                    else if(state == 1) {//<
                        if(i == ' ') {
                            state = 4;
                        } else if(i == '>'){
                            temp = new Node(tag);
                            temp.attr = attr;
                            attr = new HashMap<>();
                            this.add(temp);
                            tag = "";
                            state = 2;
                        } else if(i == '/'){
                            state = 3;
                        } else {
                            tag += i;
                        }
                    }

                    else if(state == 2){//<tmp>
                        if(i == '<'){
                            if(!tmp.isEmpty()){
                                temp.text = tmp;
                                tmp = "";
                            }
                            state = 1;
                        } else {
                            tmp += i;
                        }
                    }
                    else if(state == 3){//</tag>
                        if(i == '>'){
                            state = 0;
                            if(!this.up()) {
                                flag = false;
                                break;
                            }
                            temp = null;
                        }
                    }
                    else if(state == 4){
                        if(i == '"' && tmp.contains("\"")){
                            String[] pair = tmp.split("=");
                            tmp="";
                            attr.put(pair[0], pair[1].replace("\"", ""));
                            state = 1;
                        } else {
                            tmp += i;
                        }
                    }
                }
            }
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }

    public void add(Node node){
        if (root == null){
            root = node;
            currentNode = root;
            return;
        }

        node.parent = currentNode;
        currentNode.children.add(node);
        currentNode = node;


    }

    public boolean up(){
       try{
            currentNode = currentNode.parent;
            return true;
       } catch (Exception e){
           System.out.println(e.getMessage());
           return false;
       }
    }

    private void writeChild(Node current, BufferedWriter out, int count){
        try {
            //open tag
            for(int i = 0; i < count; i++) out.write("\t");
            out.write("<" + current.tag);

            //attr
            for(Map.Entry<String, String> i : current.attr.entrySet()){
                out.write(" " + i.getKey() + "=\"" + i.getValue() + "\"");
            }

            out.write(">");

            //text
            if(current.text != null) {
                out.write(current.text);
            } else{
                out.write("\n");
            }

            //children
            for(Node i : current.children){
                writeChild(i, out, count+1);
            }

            //close tag
            if(current.text == null) for (int i = 0; i < count; i++) out.write("\t");
            out.write("</" + current.tag + ">\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateHtml(){
        try(BufferedWriter out = new BufferedWriter(new FileWriter("homework_2_sem/src/hw4/index.html"));) {
            writeChild(root, out, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getText(){
        return NodeText(root);
    }

    private String NodeText(Node current){
        String text = current.text == null ? "" : current.text + "\n";

        for (Node i : current.children){
            text += NodeText(i);
        }

        return text;
    }
}

class Node {
    @Override
    public String toString() {
        return "Node{" +
                "tag='" + tag + '\'' +
                ", text='" + text + '\'' +
                ", children=" + children +
                ", parent=" + parent +
                ", attr=" + attr +
                '}';
    }

    String tag;
    String text;
    List<Node> children;
    Node parent;
    Map<String, String> attr;

    public Node(String tag){
        this.tag = tag;
        children = new ArrayList<>();
        attr = new HashMap<>();
    }

    public Node(String tag, String text){
        this(tag);
        this.text = text;
    }
}