package prelims;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyGrowingArrayList<T> implements MyList<T>{
    private int itemCount = 0;
    private T[] items;

    public MyGrowingArrayList(){
        int initialSize = 5;
        items = (T[]) (new Object[initialSize]);
    }

    /**displays the whole items array*/
    public void displayInfo(){
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println((i+1) +". "+ this.items[i]);
        }
    }


    /** doubles the length of the array and puts the data into the new array */
    private T[] doubleArraySizeAndPopulateArray(T[] items){
        T[] newArray;
        newArray = (T[])(new Object[getSize()*2]);
        for (int i = 0; i < newArray.length - 1; i++) {
            if(i >= this.items.length ) {
                newArray[i] = null;
            }
            else{
                newArray[i] = items[i];
            }
        }
        return newArray;
    }

    /** Implementation of MyList interface */
    @Override
    public int getSize() {
        return items.length;
    }

    @Override
    public void insert(T data) throws ListOverflowException {
        if(itemCount >= items.length){
            items = doubleArraySizeAndPopulateArray(items);
        }
        items[itemCount] = data;
        this.itemCount++;
    }

    @Override
    public T getElement(T data) throws NoSuchElementException {
        return items[Arrays.binarySearch(items, data)];
    }

    @Override
    public boolean delete(T data) {
        int index = this.search(data);
        if(index == -1){
            System.out.println("not in system");
            return false;
        }
        System.out.println(this.items[index] + "has been removed");
        this.items[index] = null;
        return true;
    }

    @Override
    public int search(T data) {
        for (int i = 0; i < this.items.length; i++) {
            if(this.items[i] == data){
                return i;
            }
        }
        return -1;
    }
}
