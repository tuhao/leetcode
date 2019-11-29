package sort;

public class QuickSort {

    //quick_sort(p...r)=quick_sort(p...q-1)+quick_sort(q+1...r)
    //终止条件p>=r

    public void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    private void quickSort(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
    }

    //    我们通过游标 i 把 A[p…r-1] 分成两部分。A[p…i-1] 的元素都是小于 pivot 的，
//    我们暂且叫它“已处理区间”，A[i…r-1] 是“未处理区间”。
//    我们每次都从未处理的区间 A[i…r-1] 中取一个元素 A[j]，与 pivot 对比，如果小于 pivot，则将其加入到已处理区间的尾部，也就是 A[i] 的位置。
    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 5, 12, 3};
        new QuickSort().quickSort(array, 5);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
