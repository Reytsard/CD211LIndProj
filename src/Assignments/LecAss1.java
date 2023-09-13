package Assignments;

import prelims.ListOverflowException;
import prelims.MySinglyLinkedList;
import prelims.Node;

public class LecAss1 {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        try {
            list.insert("apple");
            list.insert("banana");
            list.insert("pear");
//            list.insertLexi("ant");
            list.insert("orange");
            list.insert("zebra");
        } catch (ListOverflowException e) {
            System.out.println("Error" + e);
        }
        System.out.println();
        list.displayInfos();
    }
}
