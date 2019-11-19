package sort;

public class BubbleSort {

    public void bubbleSort(int a[], int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 3, 2, 1};
        new BubbleSort().bubbleSort(a, 6);
        for (int i : a) {
            System.out.println(i);
        }


    }
}
