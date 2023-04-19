package View;
import Controller.Operation;
import Controller.TreeFactory;
import Model.IMap;

import java.util.Scanner;

public class DriverProgram {
    static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
        IMap Usermap = TreeFactory.treefactory();
        //"C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\Spanish.txt"
        //C:\\Users\\Sebastian\\OneDrive - Universidad del Valle de Guatemala\\Escritorio\\POO\\HD9\\texto.txt
        start(Usermap);

    }
    public static void start(IMap map){
        int exit=1;
        while (exit==1){
            System.out.println("Bienvenido a su traductor y diccionario\nQue desea hacer?\n1. Cargar diccionario\n2. Traducir oracion\n3. Mostrar Diccionario");
            int option= in.nextInt();
            in.nextLine();
            switch (option){
                case 1:
                    System.out.println("Ingrese la direccion de documentos donde tiene las palabras");
                    String fpath= in.nextLine();
                    map.create(fpath);
                    break;
                case 2:
                    Operation operation= new Operation();
                    operation.translateSentence(map);
                    break;
                case 3:
                    map.show(map.getRoot());
                    break;
                default:
                    System.out.println("No eligio una de nuestras opciones");
                    break;
            }
            System.out.println("Desea volver a intentarlo?\n1. SI\n2. NO");
            exit= in.nextInt();
            in.nextLine();
        }
    }
}
