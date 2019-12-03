package tree;

public class Heap {

    //数组，从下标1开始存储数据
    private int[] a;
    //堆中可以存储的最大数据个数
    private int n;
    //堆中已存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, a[i], a[i / 2]);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) return;
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    //建堆 O(n)
    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i > 1; --i) {
            heapify(a, n, i);
        }
    }

    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i <= n && a[i] < a[i * 2]) maxPos = 2 * i;
            if (2 * i + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = 2 * i + 1;
            swap(a, i, maxPos);
            if (maxPos == i) break;
            i = maxPos;
        }
    }

    private void swap(int[] a, int i, int target) {
        a[i] ^= a[target];
        a[target] ^= a[i];
        a[i] ^= a[target];
    }
}
