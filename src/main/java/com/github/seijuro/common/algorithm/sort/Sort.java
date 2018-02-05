package com.github.seijuro.common.algorithm.sort;

public interface Sort {
    /**
     * swap elements which located at left and right in array.
     * primitive(int) version
     *
     * @param samples
     * @param left
     * @param right
     */
    public static void swap(int[] samples, int left, int right) {
        int tmp = samples[left];
        samples[left] = samples[right];
        samples[right] = tmp;
    }

    /**
     * swap elements which located at left and right in array.
     * object version
     *
     * @param samples
     * @param left
     * @param right
     * @param <T>
     */
    public static <T extends Comparable<T>> void swap(T[] samples, int left, int right) {
        T tmp = samples[left];
        samples[left] = samples[right];
        samples[right] = tmp;
    }

    public <T extends Comparable<T>> void sort(T[] samples, int begin, int end);
    public void sort(int[] samples, int begin, int end);
}
