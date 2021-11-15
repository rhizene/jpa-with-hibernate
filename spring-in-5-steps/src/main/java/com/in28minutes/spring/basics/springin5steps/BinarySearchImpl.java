package com.in28minutes.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private SortAlgorithm sortAlgorithm;

    public BinarySearchImpl() {}

    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
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
