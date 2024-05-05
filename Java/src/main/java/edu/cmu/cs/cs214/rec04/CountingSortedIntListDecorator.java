package edu.cmu.cs.cs214.rec04;

/**
 * Decorator class to count how many elements have been added to the wrapped SortedIntList.
 */
public class CountingSortedIntListDecorator implements IntegerList {
    private SortedIntList sortedIntList;
    private int totalAdded;

    public CountingSortedIntListDecorator(SortedIntList sortedIntList) {
        this.sortedIntList = sortedIntList;
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        boolean added = sortedIntList.add(num);
        if (added) {
            totalAdded++;
        }
        return added;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean added = sortedIntList.addAll(list);
        if (added) {
            totalAdded += list.size();
        }
        return added;
    }

    @Override
    public int get(int index) {
        return sortedIntList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedIntList.removeAll(list);
    }

    @Override
    public int size() {
        return sortedIntList.size();
    }

    @Override
    public boolean contains(int value) {
        return sortedIntList.contains(value);
    }

    @Override
    public int indexOf(int value) {
        return sortedIntList.indexOf(value);
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
