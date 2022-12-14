package collectionsImpl;

import java.util.*;

public class ListImpl<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] array;

    public ListImpl() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }

    @Override
    public boolean add(E e) {
        if (size >= capacity) {
            increasesCapacity();
        }
        array[size++] = e;
        return true;
    }

    private void increasesCapacity() {
        capacity *= 2;
        Object[] tempArray = new Object[capacity];
        if (size >= 0) System.arraycopy(array, 0, tempArray, 0, size);
        array = tempArray;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) array[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        int newSize = size - 1;
        E remoteValue = (E) array[index];
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, newSize - index);
        array[newSize] = null;
        size = newSize;
        return remoteValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
