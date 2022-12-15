package com.qirsam.collectionsImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Collections.list;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ListImplTest {

    private ListImpl<Integer> testList = new ListImpl<>(Arrays.asList(1, 56, 17, 23, 13, 2));
    public static final int TEST_INT = 42;
    private static final int TEST_INDEX = 100;

    @Test
    void add() {
        testList.add(TEST_INT);
        Integer actualResult = testList.get(testList.size() - 1);

        assertThat(actualResult).isEqualTo(TEST_INT);
    }

    @Test
    void get() {
        Integer actualResult = testList.get(2);

        assertThat(actualResult).isEqualTo(17);
    }

    @Test
    void remove() {
        Integer actualResult = testList.remove(2);

        assertThat(actualResult).isEqualTo(17);
    }

    @Test
    void size() {
        int actualResult = testList.size();

        assertThat(actualResult).isEqualTo(6);
    }

    @Test
    void clear() {
        testList.clear();
        int actualResult = testList.size();

        assertThat(actualResult).isEqualTo(0);
    }

    @Test
    void set() {
        Integer actualResult = testList.set(3, TEST_INT);

        assertThat(actualResult).isEqualTo(23);
    }

    @Test()
    void setException() {
        assertThatThrownBy(() -> testList.set(TEST_INDEX, TEST_INT))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void sort() {
        testList.sort(Comparator.naturalOrder());

        assertThat(testList).isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    void addByIndex() {
        final int oldSize = testList.size();
        testList.add(3, TEST_INT);

        assertThat(testList)
                .satisfies(list -> assertThat(list.size()).isEqualTo(oldSize + 1))
                .satisfies(list -> assertThat(list.get(3)).isEqualTo(TEST_INT));

    }

    @Test
    void addByIndexException() {
        assertThatThrownBy(() -> testList.add(TEST_INDEX, TEST_INT))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("illegal index: " + TEST_INDEX + ", list size: " + testList.size());
    }

}