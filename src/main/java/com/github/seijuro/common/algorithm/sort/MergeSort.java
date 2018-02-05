package com.github.seijuro.common.algorithm.sort;

import java.lang.reflect.Array;
import java.util.Objects;

public class MergeSort implements Sort {
    public <T extends Comparable<T>> T[] msort(T[] samples, int begin, int end) {
        Class clazz = samples[0].getClass();

        if (begin < end) {
            int middle = begin + (int)((end - begin) / 2);

            T[] lhs = msort(samples, begin, middle);
            T[] rhs = msort(samples, middle + 1, end);
            T[] ret = (T[])(Array.newInstance(clazz, lhs.length + rhs.length));

            merge(lhs, rhs, ret);

            return ret;
        }

        T[] ret = (T[])(Array.newInstance(clazz, 1));
        ret[0] = samples[begin];

        return ret;
    }

    public <T extends Comparable<T>> void merge(T[] lhs, T[] rhs, T[] out) {
        int subIdx = 0;

        for (int idx = 0; idx != lhs.length; ++idx) {
            while (subIdx < rhs.length && lhs[idx].compareTo(rhs[subIdx]) > 0) {
                out[idx + subIdx] = rhs[subIdx];
                ++subIdx;
            }

            out[idx + subIdx] = lhs[idx];
        }

        while (subIdx < rhs.length) {
            out[lhs.length + subIdx] = rhs[subIdx];
            ++subIdx;
        }
    }

    public int[] msort(int[] samples, int begin, int end) {
        if (begin == end) {
            return new int[] {samples[begin]};
        }

        if (begin < end) {
            int middle = begin + (int)((end - begin) / 2);

            int[] lhs = msort(samples, begin, middle);
            int[] rhs = msort(samples, middle + 1, end);

            return merge(lhs, rhs);
        }

        return new int[] {};
    }

    public int[] merge(int[] lhs, int[] rhs) {
        int[] ret = new int [lhs.length + rhs.length];

        int subIdx = 0;

        for (int idx = 0; idx != lhs.length; ++idx) {
            while (subIdx < rhs.length && lhs[idx] > rhs[subIdx]) {
                ret[idx + subIdx] = rhs[subIdx];
                ++subIdx;
            }

            ret[idx + subIdx] = lhs[idx];
        }

        while (subIdx < rhs.length) {
            ret[lhs.length + subIdx] = rhs[subIdx];
            ++subIdx;
        }

        return ret;
    }

    @Override
    public <T extends Comparable<T>> void sort(T[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin < end) {
            T[] ret = msort(samples, begin, end);

            for (int index = 0; index != samples.length; ++index) {
                samples[index] = ret[index];
            }
        }
    }

    @Override
    public void sort(int[] samples, int begin, int end) {
        if (Objects.nonNull(samples) && begin < end) {
            int[] ret = msort(samples, begin, end);

            for (int index = 0; index != samples.length; ++index) {
                samples[index] = ret[index];
            }
        }
    }

    public static void main(String[] args) {
        Character[] samples = {'1', 'F', 'A', 'B', 'C', 'a', 'c'};

        Sort msort = new MergeSort();
        msort.sort(samples, 0, samples.length - 1);


        for (int index = 0; index != samples.length; ++index) {
            System.out.printf("%c ", samples[index]);
        }

        System.out.println("");
    }
}
