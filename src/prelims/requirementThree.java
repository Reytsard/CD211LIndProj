package prelims;

public class requirementThree {
    public static void main(String[] args) {
        MySinglyLinkedList<String> SLL = new MySinglyLinkedList<>();
        try {
            SLL.insert("hello WOrld");
            SLL.insert("hello WOr4ld");
            SLL.insert("hello WOrl2d");
            SLL.insert("hello WOrld5");
            SLL.insert("hello WOrl6d");
            SLL.insert("hello WOrl7d");
            SLL.insert("hello WOrl9d");
            SLL.insert("POTATNO NANANA");
        } catch (ListOverflowException e) {
            System.out.println("Error" + e);
        }
        SLL.delete("hello WOrl6d");
        SLL.delete("hello WOrld");
        SLL.delete("POTATNO NANANA");
        SLL.displayInfos();

    }
}
