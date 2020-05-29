package AiSD.Task6;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {566,25,36,367,367,437,378,4,9};
        int[] result = mergeSort(array);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] leftArray = mergeSort(Arrays.copyOf(array, array.length / 2));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));

        int leftCursor = 0;
        int rightCursor = 0;
        int[] result = new int[array.length];

        for (int i = 0; i < array.length && leftCursor < leftArray.length && rightCursor < rightArray.length; i++) {
            if (leftArray[leftCursor] <= rightArray[rightCursor]) {
                result[i] = leftArray[leftCursor];
                leftCursor++;
            } else {
                result[i] = rightArray[rightCursor];
                rightCursor++;
            }
        }

        if (leftCursor == leftArray.length) {
            for (int i = rightCursor; i < rightArray.length ; i++) {
                result[i + leftCursor] = rightArray[i];
            }
        } else {
            for (int i = leftCursor; i < leftArray.length; i++) {
                result[i + rightCursor] = leftArray[i];
            }
        }

        return result;
    }
}
