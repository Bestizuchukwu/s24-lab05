package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.List;

/**
 * SortedIntList - a list of integers sorted in ascending order.
 */
public class SortedIntList implements IntegerList {
    private List<Integer> sortedList;

    public SortedIntList() {
        sortedList = new ArrayList<>();
    }

    @Override
    public boolean add(int num) {
        int index = findInsertionIndex(num);
        sortedList.add(index, num);
        return true;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean added = false;
        for (int i = 0; i < list.size(); i++) {
            if (add(list.get(i))) {
                added = true;
            }
        }
        return added;
    }

    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedList.remove((Integer) num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean success = true;
        for (int i = 0; i < list.size(); i++) {
            success &= remove(list.get(i));
        }
        return success;
    }

    @Override
    public int size() {
        return sortedList.size();
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

    /**
     * Finds the insertion index for a new element in the sorted list.
     *
     * @param num the number to be inserted
     * @return the index where the number should be inserted
     */
    private int findInsertionIndex(int num) {
        int index = 0;
        while (index < sortedList.size() && sortedList.get(index) < num) {
            index++;
        }
        return index;
    }
}
