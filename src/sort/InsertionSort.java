package sort;

public class InsertionSort {

    public void insertionSort(int a[], int n) {
        if (n <= 1) return;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 3, 2, 1};
        new InsertionSort().insertionSort(a, 6);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
