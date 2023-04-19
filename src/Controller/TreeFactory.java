package Controller;

import Model.AVL;
import Model.IMap;
import Model.RedBlack;

import java.util.Scanner;

public class TreeFactory {
    static Scanner in= new Scanner(System.in);
    public static IMap treefactory(){
        System.out.println("Con que desea realizar su programa?\n1. RedBlack\n2. AVL");
        int option= in.nextInt();
        IMap actualMap=null;
        switch (option){
            case 1:
                actualMap=new RedBlack();
                break;
            case 2:
                actualMap=new AVL();
                break;
        }
        return actualMap;
    }
}
