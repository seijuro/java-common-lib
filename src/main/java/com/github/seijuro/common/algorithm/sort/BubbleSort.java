package com.github.seijuro.common.algorithm.sort;

import java.util.Objects;

/**
 * Bublle Sort
 *
 */
public class BubbleSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin < end) {
            for (int index = begin; index < end; ++index) {
                for (int subIndex = begin; subIndex < end - index; ++subIndex) {
                    if (samples[subIndex].compareTo(samples[subIndex + 1]) > 0) {
                        Sort.swap(samples, subIndex, subIndex + 1);
                    }
                } //   inner iteration
            } //  outer iteration
        } //  checking input
    }

    @Override
    public void sort(int[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin < end) {
            for (int index = begin; index < end; ++index) {
                for (int subIndex = begin; subIndex < end - index; ++subIndex) {
                    if (samples[subIndex] > samples[subIndex + 1]) {
                        Sort.swap(samples, subIndex, subIndex + 1);
                    }
                } //   inner iteration
            } //  outer iteration
        } //  checking input
    }
}
