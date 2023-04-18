package View;

import Controller.ReadFile;
import Model.AVL;
import Model.Association;
import Model.RedBlack;

import java.util.ArrayList;

public class DriverProgram {
    public static void main(String[] args) {
        //"C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt"
        //"C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\texto.txt"

        RedBlack rb= new RedBlack();
        AVL avl= new AVL();
        Association ass = new Association<>("all", "todo");

        rb.createRB("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
        avl.create("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
        avl.show(avl.root);
    }
}
