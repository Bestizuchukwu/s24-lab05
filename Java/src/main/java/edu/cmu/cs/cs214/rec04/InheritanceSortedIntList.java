package edu.cmu.cs.cs214.rec04;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    // Write your implementation below with API documentation
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        int oldSize = size();
        boolean success = super.addAll(list);
        if (success) {
            int newSize = size();
            int addedCount = newSize - oldSize;
            totalAdded += addedCount; // Increment the totalAdded count by the number of added elements
        }
        return success;
    }

@Override
public boolean removeAll(IntegerList list) {
    int oldSize = size();
    boolean success = false;
    for (int i = 0; i < list.size(); i++) {
        if (remove(list.get(i))) { // Try to remove each element individually
            success = true; // At least one element was removed
        }
    }
    if (success) {
        int newSize = size();
        int removedCount = oldSize - newSize;
        totalAdded -= removedCount;
    }
    return success;
}



    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == value) {
                return i;
            }
        }
        return -1;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
