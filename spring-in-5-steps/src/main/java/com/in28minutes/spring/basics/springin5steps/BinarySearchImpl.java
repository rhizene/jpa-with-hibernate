package com.in28minutes.spring.basics.springin5steps;

public class BinarySearchImpl {

    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    /**
     * Sort, search, and return result
     */
    public int binarySearch(int[] numbers, int numberTosearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        return 3;
    }

}
