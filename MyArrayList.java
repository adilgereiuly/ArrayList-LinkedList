public class MyArrayList<T> implements MyList<T> {
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
}
