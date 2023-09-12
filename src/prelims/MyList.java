package prelims;

import java.util.NoSuchElementException;
public interface MyList<E> {
    int getSize();
    void insert(E data) throws ListOverflowException;
    E getElement(E data) throws NoSuchElementException;
    boolean delete(E data); // returns false if the data is not deleted in the list
    int search(E data); // returns index of data, else -1 is return
}

