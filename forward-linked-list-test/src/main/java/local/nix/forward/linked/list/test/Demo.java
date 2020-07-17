package local.nix.forward.linked.list.test;

import local.nix.forward.linked.list.util.StringListHandler;
import local.nix.forward.linked.list.util.list.ForwardLinkedList;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

       List<String> list = new ForwardLinkedList<>();

       list.add("string 1 text 45 dsjs1");
       list.add("hdhdh4 chchd67 8ff");
       System.out.println(list);
       System.out.println("size of the list = " + list.size());

       Integer result1 = StringListHandler.getNumbersFromStringFirstWay(list);
       System.out.println("Number from strings of the list (first way)  = " + result1);

       Integer result2 = StringListHandler.getNumbersFromStringFirstWay(list);
       System.out.println("Number from strings of the list (second way)  = " + result2);
    }
}
