package Controller;

import Model.AVL;
import Model.IMap;
import Model.RedBlack;

import java.util.Map;

public class TreeFactory {
    public static IMap treefactory(int option){
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
