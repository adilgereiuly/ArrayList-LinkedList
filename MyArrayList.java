/**
 * Dynamic array implementation of MyList.
 * Automatically grows in size when capacity is exceeded.
 * @param <T> the type of elements in the list
 */


public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
private Object[] array;
private int size;

private void increaseCapacity() {
int newCapacity = array.length * 2;
Object[] newArray = new Object[newCapacity];
for (int i = 0; i < array.length; i++) {
    newArray[i] = array[i]; }
array = newArray; }

public MyArrayList() {
array = new Object[5];
size = 0; }

public void add(T item) {
    if (size == array.length) {
        increaseCapacity(); }
    array[size] = item;
    size++; }

public int size() {
    return size; }

public boolean isEmpty() {
        return size == 0; }

public void clear() {
    for (int i = 0; i < size; i++) {
        array[i] = null; }
    size = 0; }

public T get(int index) {
        if (index < 0 || index > size-1) {
            throw new IndexOutOfBoundsException(); }
return (T) array[index]; }


public void add(int index, T item) {
    if (size == array.length) {
        increaseCapacity(); }
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException(); }
for (int i = size; i > index; i--) {
    array[i] = array[i-1]; }
array[index] = item;
size++; }

public T remove(int index) {
    if (index < 0 || index > size-1) {
        throw new IndexOutOfBoundsException(); }
    Object deletion = array[index];
    for (int i = index; i < size-1; i++) {
        array[i] = array[i+1];
    }
    array[size-1] = null;
    size--;
    return (T) deletion; }



public boolean remove(T item) {
for (int i = 0; i < size; i++) {
if (array[i].equals(item)) {
 remove(i);
 return true; }


        }
return false;
    }

    public T set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T old = (T) array[index];
        array[index] = item;
        return old;
    }

    public void sort() {
        // Simple bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T current = (T) array[j];
                T next = (T) array[j + 1];
                if (current.compareTo(next) > 0) {
                    // Swap
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(Object item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    public boolean exists(Object item) {
        return indexOf(item) != -1;
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
