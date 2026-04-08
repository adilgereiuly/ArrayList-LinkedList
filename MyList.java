/**
 * Generic list interface that defines common operations for all list implementations.
 * @param <T> the type of elements in the list
 */

public interface MyList<T> {
    void add(T item);
    void add(int index, T item);
    T get(int index);
    T remove(int index);
    boolean remove(T item);
    int size ();
    boolean isEmpty ();
    void clear ();
    T set(int index, T item);
    void sort();
    int indexOf(Object item);
    int lastIndexOf(Object item);
    boolean exists(Object item);
    Object[] toArray();
}
