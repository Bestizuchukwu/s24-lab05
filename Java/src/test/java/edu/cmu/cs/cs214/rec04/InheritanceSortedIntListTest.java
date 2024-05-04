package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * Tests for the InheritanceSortedIntList class.
 *
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntListTest {

    private InheritanceSortedIntList list1;
    private InheritanceSortedIntList list2;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        list1 = new InheritanceSortedIntList();
        list2 = new InheritanceSortedIntList();
    }

    /**
     * Tests for the add() method.
     */
    @Test
    public void testAdd() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertEquals(5, list1.getTotalAdded());
        printList(list1);
    }

    /**
     * Tests for the addAll() method.
     */
    @Test
    public void testAddAll() {
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        assertEquals(5, list1.getTotalAdded());

        list2.add(3);
        list2.add(0);
        assertEquals(2, list2.getTotalAdded());

        list2.addAll(list1);

        int expectedTotalAdded = list2.getTotalAdded();
        assertEquals(expectedTotalAdded, list2.getTotalAdded());
    }



    @Test
public void testRemoveAll() {
    list1.add(1);
    list1.add(2);
    list1.add(3);

    IntegerList toRemove = new IntegerList() {
        private List<Integer> elements = new ArrayList<>();

        @Override
        public boolean add(int num) {
            return elements.add(num);
        }

        @Override
        public boolean addAll(IntegerList list) {
            for (int i = 0; i < list.size(); i++) {
                elements.add(list.get(i));
            }
            return true;
        }

        @Override
        public int get(int index) {
            return elements.get(index);
        }

        @Override
        public boolean remove(int num) {
            return elements.remove((Integer) num);
        }

        @Override
        public boolean removeAll(IntegerList list) {
            boolean result = false;
            for (int i = 0; i < list.size(); i++) {
                if (elements.remove((Integer) list.get(i))) {
                    result = true;
                }
            }
            return result;
        }

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        public boolean contains(int value) {
            return elements.contains(value);
        }

        @Override
        public int indexOf(int value) {
            return elements.indexOf(value);
        }
    };

    toRemove.add(2);
    toRemove.add(3);

    list1.removeAll(toRemove);

    assertEquals(1, list1.size());
    assertTrue(list1.contains(1));
    assertFalse(list1.contains(2));
    assertFalse(list1.contains(3));
}


    

    /**
     * Tests for the remove() method.
     */
    @Test
    public void testRemove() {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list1.remove(2);

        assertEquals(2, list1.size());
        assertTrue(list1.contains(1));
        assertFalse(list1.contains(2));
        assertTrue(list1.contains(3));
    }

    /**
     * A helper function that prints out the contents of an IntegerList.
     * @param list IntegerList to be printed out.
     */
    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}
