package prelims;

import java.lang.reflect.Array;

public class requirementTwo {
    public static void main(String[] args) {
        MyGrowingArrayList<String> growingArray = new MyGrowingArrayList<>();
        try {
            growingArray.insert("Hello");
            growingArray.insert("Hello world");
            growingArray.insert("Hello");
            growingArray.insert("Hello world");
            growingArray.insert("Hello");
            growingArray.insert("Hello world");
            growingArray.insert("Hello");
            growingArray.insert("Hello world");
            growingArray.insert("9th data");
            growingArray.insert("10th data");
            growingArray.insert("11th data");

        } catch (ListOverflowException e) {
            System.out.println("Error: "+ e);
        }
        growingArray.displayInfo();

    }
}
