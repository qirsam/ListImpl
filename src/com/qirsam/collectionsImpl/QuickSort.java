import java.util.Comparator;
import java.util.List;

public class QuickSort {

    public static <E> void quickSort(ListImpl<E> list, Comparator<? super E> cmp) {
        quickSort(list, 0, list.size() - 1, cmp);
    }

    private static <E> void quickSort(ListImpl<E> list, int from, int to, Comparator<? super E> cmp) {
        if (list.size() == 0 || from >= to) {
            return;
        }

        int receivedIndex = partition(list, from, to, cmp);
        quickSort(list, from, receivedIndex - 1, cmp);
        quickSort(list, receivedIndex, to, cmp);
    }

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

    private static <E> void swap(ListImpl<E> list, int firstIndex, int secondIndex) {
        E tempValue = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tempValue);
    }

}
