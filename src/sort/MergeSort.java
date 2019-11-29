package sort;

public class MergeSort {

    //递推公式： merge_sort(p...r)=merge(merge_sort(p...q),merge_sort(q+1...r))
    //终止条件：p>=r不用继续分解

    private void mergeSort(int[] array, int n) {
        mergeSort(array, 0, n - 1);
    }

    private void mergeSort(int[] array, int p, int r) {
        if (p >= r) return;
        int q = p + (r - p) / 2;
        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);
        merge(array, p, q, r);
    }

    private void merge(int[] array, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = array[start++];
        }
        for (i = 0; i <= r - p; i++) {
            array[p + i] = tmp[i];
        }
    }
}
