package com.github.seijuro.common.algorithm.sort;

import java.util.Objects;

public class QuickSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin >= end) return;

        T pivot = samples[begin];

        int lhsIndex = begin;
        int rhsIndex = end;

        while (lhsIndex < rhsIndex) {
            //  find the pos of first element which is smaller than pivot from right
            while (lhsIndex < rhsIndex && (pivot.compareTo(samples[rhsIndex]) < 0)) --rhsIndex;
            //  find the pos of first element which is bigger than pivot from left.
            while (lhsIndex < rhsIndex && (samples[lhsIndex].compareTo(pivot) <= 0)) ++lhsIndex;

            if (lhsIndex <= rhsIndex) {
                Sort.swap(samples, lhsIndex, rhsIndex);
            }
        }

        Sort.swap(samples, begin, lhsIndex);

        sort(samples, begin, lhsIndex - 1);
        sort(samples, lhsIndex + 1, end);
    }

    @Override
    public void sort(int[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin >= end) return;

        int pivot = samples[begin];

        int lhsIndex = begin;
        int rhsIndex = end;

        while (lhsIndex < rhsIndex) {
            //  find the pos of first element which is smaller than pivot from right
            while (lhsIndex < rhsIndex && pivot < samples[rhsIndex]) --rhsIndex;
            //  find the pos of first element which is bigger than pivot from left.
            while (lhsIndex < rhsIndex && samples[lhsIndex] <= pivot) ++lhsIndex;

            if (lhsIndex <= rhsIndex) {
                Sort.swap(samples, lhsIndex, rhsIndex);
            }
        }

        Sort.swap(samples, begin, lhsIndex);

        sort(samples, begin, lhsIndex - 1);
        sort(samples, lhsIndex + 1, end);
    }
}
