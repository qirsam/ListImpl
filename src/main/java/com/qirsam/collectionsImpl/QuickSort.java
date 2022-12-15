package com.qirsam.collectionsImpl;

import java.util.Comparator;

/**
 * Класс релизующий алгоритм "Быстрая сортировка" для коллекции типа {@link ListImpl}, для сортировки
 * используйте метод {@link QuickSort#quickSort(ListImpl, Comparator)}
 */
public class QuickSort {

    /**
     * Сортировка коллекции типа {@link ListImpl} с помощью функции сравнения {@link Comparator}
     *
     * @param list - необходимая коллекция типа
     * @param cmp - объект типа {@link Comparator}, для сравнения
     * @param <E> - тип элементов листа
     */
    public static <E> void quickSort(ListImpl<E> list, Comparator<? super E> cmp) {
        quickSort(list, 0, list.size() - 1, cmp);
    }

    /**
     * Метод реализующий быструю сортировку в рекурсии
     *
     * @param list - коллекция для разделения
     * @param from - начало диапазона
     * @param to   - конец диапазона
     * @param cmp  - объект типа {@link Comparator}, для сравнения
     * @param <E> - тип элементов листа
     */
    private static <E> void quickSort(ListImpl<E> list, int from, int to, Comparator<? super E> cmp) {
        if (list.size() == 0 || from >= to) {
            return;
        }

        int receivedIndex = partition(list, from, to, cmp);
        quickSort(list, from, receivedIndex - 1, cmp);
        quickSort(list, receivedIndex, to, cmp);
    }

    /**
     * Нахождение границы для разделения коллекции на подколлекции
     *
     * @param list - коллекция для разделения
     * @param from - начало диапазона
     * @param to   - конец диапазона
     * @param cmp  - объект типа {@link Comparator}, для сравнения
     * @param <E> - тип элементов листа
     * @return
     */
    private static <E> int partition(ListImpl<E> list, int from, int to, Comparator<? super E> cmp) {
        int leftIndex = from;
        int rightIndex = to;

        int middle = from + (to - from) / 2;
        E pivot = list.get(middle);

        while (leftIndex <= rightIndex) {

            while (cmp.compare(list.get(leftIndex), pivot) < 0) {
                leftIndex++;
            }

            while (cmp.compare(list.get(rightIndex), pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(list, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    /**
     * Меняем элементы местами по индексу
     *
     * @param list
     * @param firstIndex
     * @param secondIndex
     */
    private static <E> void swap(ListImpl<E> list, int firstIndex, int secondIndex) {
        E tempValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tempValue);
    }

}
