import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        ListImpl<Integer> list = new ListImpl<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        extracted(list);

        QuickSort.quickSort(list, Comparator.naturalOrder());

        extracted(list);


    }

    private static void extracted(ListImpl<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }
        System.out.println();
    }
}