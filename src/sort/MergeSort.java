package sort;

public class MergeSort {

    private void mergeSort(int array[], int start, int end) {
        if (start > end) {
            int mid = start + end / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            mergeSort(array, start, mid, end);
        }
    }

    private void mergeSort(int[] array, int start, int mid, int end) {
        int p1 = 0, p2 = mid, p = 0;
        int[] tempArray = new int[end - start + 1];
        while (p1 <= mid && p2 <= end) {
            if (array[p1] <= array[p2]) {
                tempArray[p++] = array[p1++];
            } else {
                tempArray[p++] = array[p2++];
            }
        }

        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }
}
