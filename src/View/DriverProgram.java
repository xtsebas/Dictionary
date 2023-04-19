package View;

import Controller.Operation;
import Controller.ReadFile;
import Controller.TreeFactory;
import Model.AVL;
import Model.Association;
import Model.IMap;
import Model.RedBlack;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        //"C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt"
        //C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\texto.txt
        Scanner in= new Scanner(System.in);
       System.out.println("CUal prefiere: \n1. RedBlack\n2. AVL");
       int option= in.nextInt();
       IMap userMap= TreeFactory.treefactory(option);
       userMap.create("C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt");
       userMap.show(userMap.getRoot());

        Operation operation= new Operation();
        operation.translateSentence(userMap);
    }
}
