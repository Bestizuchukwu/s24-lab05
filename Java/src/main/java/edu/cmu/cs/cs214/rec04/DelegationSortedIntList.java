package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 */
public class DelegationSortedIntList implements IntegerList {
    // Underlying SortedIntList to delegate functionality
    private final SortedIntList sortedIntList = new SortedIntList();
    // Count of total attempted element insertions
    private int totalAdded = 0;

    /**
     * Adds the specified int to the list.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    public boolean add(int num) {
        totalAdded++; // Increment totalAdded on each insertion attempt
        return sortedIntList.add(num);
    }

    /**
     * Adds all of the elements of the IntegerList to the list.
     * Calls add() on each element of list. Can be overwritten
     * for more specific behavior.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    public boolean addAll(IntegerList list) {
        totalAdded += list.size(); // Increment totalAdded by size of the provided list
        return sortedIntList.addAll(list);
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        return sortedIntList.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present (optional operation).
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    public boolean remove(int num) {
        return sortedIntList.remove(num);
    }

    /**
     * Removes from the list all of its elements that are contained in the
     * specified IntegerList.
     *
     * @param list IntegerList containing elements to be removed from
     *             the list
     * @return true if the list changed as a result of the call
     */
    public boolean removeAll(IntegerList list) {
        return sortedIntList.removeAll(list);
    }

    /**
     * Returns the number of elements in this list. If this list contains
     * more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return number of elements in the list
     */
    public int size() {
        return sortedIntList.size();
    }

    

    /**
     * Returns the total number of attempted element insertions.
     *
     * @return the total number of attempted element insertions
     */
    public int getTotalAdded() {
        return totalAdded;
    }

    @Override
    public boolean contains(int value) {
        return sortedIntList.contains(value);
    }

    @Override
    public int indexOf(int value) {
        return sortedIntList.indexOf(value);
    }
}




































// package edu.cmu.cs.cs214.rec04;

// /**
//  * DelegationSortedIntList -- a variant of a SortedIntList that keeps
//  * count of the number of attempted element insertions (not to be confused
//  * with the current size, which goes down when an element is removed)
//  * and exports an accessor (totalAdded) for this count.
//  *
//  * @author Nora Shoemaker
//  *
//  */

// public class DelegationSortedIntList {
//     // Write your implementation below with API documentation
//     private DelegationSortedIntList list;

//     @Before
//     public void setUp() {
//         list = new DelegationSortedIntList();
//     }

//     @Test
//     public void testAdd() {
//         assertTrue(list.add(5));
//         assertTrue(list.add(10));
//         assertTrue(list.add(2));

//         assertEquals(3, list.getTotalAdded());
//     }

//     @Test
//     public void testAddAll() {
//         IntegerList intList = new BasicIntList();
//         intList.add(7);
//         intList.add(11);
//         intList.add(3);

//         assertTrue(list.addAll(intList));

//         assertEquals(3, list.getTotalAdded());
//     }

//     @Test
//     public void testCombined() {
//         assertTrue(list.add(5));
//         assertTrue(list.add(10));
//         assertTrue(list.add(2));

//         IntegerList intList = new BasicIntList();
//         intList.add(7);
//         intList.add(11);
//         intList.add(3);

//         assertTrue(list.addAll(intList));

//         assertEquals(6, list.getTotalAdded());
//     }

// }