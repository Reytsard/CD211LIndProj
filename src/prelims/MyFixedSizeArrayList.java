package prelims;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyFixedSizeArrayList<T> implements MyList<T> {
    static final int maximum = 5;
    private final T[] items;
    public MyFixedSizeArrayList(){
        // other statements may be here
        items = (T[])(new Object[maximum]);
    }
    public void populateArray(T name, T age, T modelNumber, T color, T status){
        items[0] = name;
        items[1] = age;
        items[2] = modelNumber;
        items[3] = color;
        items[4] = status;
    }
    public void setName(T name){
        items[0] = name;
    }
    public void setAge(T age){
        items[1] = age;
    }
    public void setModelNumber(T modelNumber){
        items[2] = modelNumber;
    }
    public void setColor(T color){
        items[3] = color;
    }
    public void setStatus(T status){
        items[4] = status;
    }
    public T getName(){
        return this.items[0];
    }
    public T getAge(){
        return this.items[1];
    }
    public T getModelNumber(){
        return this.items[2];
    }
    public T getColor(){
        return this.items[3];
    }
    public T getStatus(){
        return this.items[4];
    }

    public void displayInfo(){
        System.out.println("name: " + getName());
        System.out.println("age: " + getAge());
        System.out.println("Model Number: " + getModelNumber());
        System.out.println("color: " + getColor());
        System.out.println("status: " + getStatus());
    }
    /** implementation of the MyList interface */
    @Override
    public int getSize() {
        return items.length;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        try{
            items[getSize()] = data;
        }catch (ArrayIndexOutOfBoundsException ex){
            throw new ListOverflowException("ListOverFlowException Error");
        }
    }
    @Override
    public T getElement(T data) throws NoSuchElementException {
        return null;
    }

    @Override
    public boolean delete(T data) {
        if (this.search(data) ==-1){
            System.out.println("not in system");
            return false;
        }
        this.items[this.search(data)] = null;
        System.out.println("Item cleared");
        return true;
    }

    @Override
    public int search(T data) {
        return Arrays.binarySearch(this.items, data);
    }
}
