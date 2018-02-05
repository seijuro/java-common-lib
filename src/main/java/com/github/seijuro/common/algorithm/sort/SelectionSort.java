package com.github.seijuro.common.algorithm.sort;

import java.util.Objects;

public class SelectionSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin < end) {
            for (int index = begin; index != end; ++index) {
                int smallest = index;

                for (int index2 = index + 1; index2 <= end; ++index2) {
                    if (samples[smallest].compareTo(samples[index2]) > 0) {
                        smallest = index2;
                    }
                }

                if (index != smallest) {
                    Sort.swap(samples, index, smallest);
                }
            }
        }
    }

    @Override
    public void sort(int[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin < end) {
            for (int index = begin; index != end; ++index) {
                int smallest = index;

                for (int index2 = index + 1; index2 <= end; ++index2) {
                    if (samples[smallest] > samples[index2]) {
                        smallest = index2;
                    }
                }

                if (index != smallest) {
                    Sort.swap(samples, index, smallest);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] samples = {9, 5, 4,1,2,3,8,6,7};

        Sort ssort = new SelectionSort();
        ssort.sort(samples, 0, samples.length - 1);

        System.out.println("");
    }
}
