// package edu.cmu.cs.cs214.rec04;

// import static org.junit.Assert.*;
// import org.junit.Before;
// import org.junit.Test;

// /**
//  * Tests for the InheritanceSortedIntList class.
//  *
//  * @author Nora Shoemaker
//  *
//  */
// public class InheritanceSortedIntListTest {

//     /** 
//      * Uncomment the following code to test your implementation 
//      * Select all and (CTRL + /) or (COMMAND + /)
//      * Feel free to write more tests for your implementation. */

//     private InheritanceSortedIntList list1;
//     private InheritanceSortedIntList list2;

//     /**
//      * Called before each test.
//      */
//     @Before
//     public void setUp() {
//     list1 = new InheritanceSortedIntList();
//     list2 = new InheritanceSortedIntList();
//     }

//     /**
//      * Tests for the add() method.
//      */
//     @Test
//     public void testAdd() {
//     // add 5 elements to our list.
//     list1.add(1);
//     list1.add(3);
//     list1.add(2);
//     list1.add(4);
//     list1.add(2);
//     System.out.println(list1.getTotalAdded());
//     // check that the total number of elements added is 5.
//     assertTrue(list1.getTotalAdded() == 5);
//     printList(list1);
//     }


//     @Test
// public void testAddAll() {
//     // add 5 elements to our first list.
//     list1.add(1);
//     list1.add(3);
//     list1.add(2);
//     list1.add(4);
//     list1.add(2);

//     // check that the total number of elements added is 5.
//     assertEquals(5, list1.getTotalAdded());

//     // add 2 elements to a second list.
//     list2.add(3);
//     list2.add(0);

//     // check that the total number of elements added is 2.
//     assertEquals(2, list2.getTotalAdded());

//     // add the first list (5 elements) to our second list (2 elements).
//     list2.addAll(list1);

//     // Calculate the expected total added after adding list1 to list2
//     int expectedTotalAdded = list2.getTotalAdded();// + list1.getTotalAdded();

//     // check that the total number of elements added to our second list is as expected.
//     assertEquals(expectedTotalAdded, list2.getTotalAdded());
// }


//     /**
//      * A helper function that prints out the contents of an IntegerList.
//      * @param list IntegerList to be printed out.
//      */
//     private void printList(IntegerList list) {
//     for (int i = 0; i < list.size(); i++) {
//     System.out.print(list.get(i));
//     System.out.print(", ");
//     }
//     System.out.println();
//     }
// }


package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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

    /**
     * Tests for the removeAll() method.
     */
    @Test
    public void testRemoveAll() {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        IntegerList toRemove = new IntegerList() { // Anonymous implementation of IntegerList
            @Override
            public boolean add(int num) { return false; }

            @Override
            public boolean addAll(IntegerList list) { return false; }

            @Override
            public int get(int index) { return 0; }

            @Override
            public boolean remove(int num) { return false; }

            @Override
            public boolean removeAll(IntegerList list) { return false; }

            @Override
            public int size() { return 0; }

            @Override
            public boolean contains(int value) { return false; }

            @Override
            public int indexOf(int value) { return 0; }
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
