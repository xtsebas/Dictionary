package Controller;

import Model.IMap;
import Model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Operation {
    Scanner in = new Scanner(System.in);
    public void translateSentence(IMap tree) {
        System.out.println("Ingrese la direccion txt de su oracion");
        String fpath= in.nextLine();
        String sentences= ReadFile.oration(fpath);
        ArrayList list = new ArrayList(Arrays.asList((sentences.split(" "))));
        String lower= (String) list.get(0);
        list.set(0, lower.toLowerCase());
        ArrayList language1 = new ArrayList(list);
        ArrayList array = new ArrayList();
        for (Object word : list) {
            for (int i = 0; i < list.size(); i++) {
                if (word == list.get(i)) {
                    array.add(change(tree.getRoot(), ((String) list.get(i)).toLowerCase()));
                }
            }
        }
        String sentence="";
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) != null) {
                String word = (String) array.get(i);
                ArrayList provisional = new ArrayList(Arrays.asList(word.split(" ")));
                for (int j = 0; j < provisional.size(); j++) {
                    for (int k = 0; k < language1.size(); k++) {
                        if (language1.get(k).equals(provisional.get(j+1))) {
                            language1.set(k, provisional.get(j+3));
                        }
                    }
                    if (provisional.get(0).equals("ingles")){
                        sentence= "La oracion: " + String.join(" ", list) + ", esta en ingles" + "\nEspañol: " + String.join(" ", language1);
                    } else if (provisional.get(0).equals("espanol")) {
                        sentence= "La oracion: " + String.join(" ", list) + ", esta en español" + "\nIngles: " + String.join(" ", language1);
                    }
                    j=4;
                }
            }
        }
        System.out.println(sentence);
    }

    public String change(Node node, String key){
        String nodes= null;
        int count = 0;
        if (node != null) {
            if (node.left != null && nodes ==null) {
                nodes= change(node.left, key);
            }
            if (key.equals(node.association.getKey()) && count==0 && nodes ==null) {
                nodes = "ingles " + node.association.getKey() + " " + node.association.getValue();
                count=1;
            }
            if (node.right != null && nodes ==null) {
                nodes = change(node.right, key);
            }
        }
        return nodes;
    }
}
