package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

/**
 * Subclass of SortedIntList that counts how many elements have been added to the list.
 */
public class CountingSortedIntList extends SortedIntList {
    private int totalAdded;

    public CountingSortedIntList() {
        super();
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        boolean added = super.add(num);
        if (added) {
            totalAdded++;
        }
        return added;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean added = super.addAll(list);
        if (added) {
            totalAdded += list.size();
        }
        return added;
    }

    /**
     * Get the total number of elements added to the list.
     *
     * @return The total number of elements added.
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}
