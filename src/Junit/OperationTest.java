package Junit;

import Controller.Operation;
import Model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    Operation operation = new Operation();
    IMap rb= new RedBlack();
    IMap avl= new AVL();
    Node n;

    @org.junit.jupiter.api.Test
    void search() {
        rb.create("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
        avl.create("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
        String result = "ingles asked  pregunto";
        assertEquals(operation.change(rb.getRoot(), "asked"), result);
        assertEquals(operation.change(avl.getRoot(), "asked"), result);
    }

    @Test
    void insertRB(){
        rb.create("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
        Association association= new Association<>("woman", "mujer");
        assertEquals(rb.insertNode(n,association), rb.getRoot());
    }

    @Test
    void insertAVL(){
        avl.create("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
        Association association= new Association<>("woman", "mujer");
        assertEquals(avl.insertNode(avl.getRoot(),association), avl.getRoot());
    }
}