package com.qirsam.collectionsImpl;

import java.util.*;


/**
 * Реализация интерфейса List с изменяемым размером массива.
 * Реализует такие операции со списком как, добавление элемента, добавление элемента
 * по определенному индексу, удаление элемента по определенному индексу,
 * получение элемента по индексу, очистка списка, получения размера списка.
 * @param <E>
 */
public class ListImpl<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] array;

    /**
     * Создает пустой список с размером равным десяти
     */
    public ListImpl() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }

    /**
     * Создает список, содержащий элементы указанной коллекции, в том порялдке, в котором они
     * возвращаются итератором коллекции.
     * @param collection - коллекция, элементы которой необходимо поместить в список
     */
    public ListImpl(Collection<? extends E> collection) {
        Object[] newArray = collection.toArray();
        size = newArray.length;
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
        while (capacity < size) {
            increasesCapacity();
        }
        array = Arrays.copyOf(newArray, capacity, Object[].class);
        System.out.println();

    }

    /**
     * Добавляет указанный элемент в конец этого списка
     * @param e  элемент, который  будет добавлен к этому списку
     * @return true, как указанно в спецификации {@link Collection#add}
     */
    @Override
    public boolean add(E e) {
        if (size >= capacity) {
            increasesCapacity();
        }
        array[size++] = e;
        return true;
    }

    /**
     * Возвращает элемент по указаному индексу в этом списке
     * @param index индекс элемента, который необходимо вернуть
     * @return элемент по укаханному индексу в этом списке
     * @throws IndexOutOfBoundsException - если индекс выходит за пределы допустимого диапазона
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) array[index];
    }

    /**
     * Удалеяет элемент по указанному индексу в этом списке. Все последующие за ним элементы сдвигаются
     * влево. (Вычитается единица из их индекса)
     * @param index индекс удаляемого элемента
     * @return элемент, который был удален
     * @throws IndexOutOfBoundsException - если индекс выходит за пределы допустимого диапазона
     */
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

    /**
     * Удаляет все элементы из этого списка
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Возвращает размер списка
     * @return размер списка
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Заменяет элемент по указанному индексу на переданный элемент
     * @param index индекс элемента для замены
     * @param element элемент, который будет хрантиться по указанному индексу
     * @return элемент, который ранее находился по указанному индексу
     * @throws IndexOutOfBoundsException - если переданный индекс выходит за пределы допустимого
     * диапазона
     */
    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldElement = this.get(index);
        array[index] = element;
        return oldElement;
    }

    /**
     * Сортирует этот список алгоритмом быстрой сортировки в соответствии с порядком,
     * заданным указанным {@link Comparator}.
     * @param c  {@code Comparator} используемый для сравнения элеменетов списка.
     */
    @Override
    public void sort(Comparator<? super E> c) {
        QuickSort.quickSort(this, c);
    }

    /**
     * Вставляет указанный элемент в указанную позицию в этом списке.
     * Сдвигает элемент, находящийся в данный момент в этой позиции (если есть),
     * и любые последующие элементы вправо (добавляет единицу к их индексам).
     * @param index индексм по которому необходимо вставить элемент
     * @param element элемент, которйы необходимо вставить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы допустимого диапазона
     */
    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        int newSize = size + 1;
        if (newSize >= capacity) {
            increasesCapacity();
        }
        System.arraycopy(array, index, array, index + 1, newSize - index);
        array[index] = element;
        size = newSize;
    }

    /**
     * проверка индекса, для добавления файла
     * @param index
     */
    private void checkIndexForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("illegal index: " + index + ", list size: " + size);
    }

    /**
     * Увеличение внутренного размера списка
     */
    private void increasesCapacity() {
        capacity *= 2;
        Object[] tempArray = new Object[capacity];
        if (size >= 0) System.arraycopy(array, 0, tempArray, 0, size);
        array = tempArray;
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
        return array;
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
