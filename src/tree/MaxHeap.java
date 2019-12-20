package tree;

public class MaxHeap {

    //堆元素下标从0开始
    private int[] a;
    private int count;

    public MaxHeap(int capacity) {
        this.a = new int[capacity];
        this.count = 0;
    }

    public void insert(int data) {
        if (count >= a.length) return; // 堆满了
        a[count] = data;
        int i = count;
        ++count;
        while ((i - 1) / 2 >= 0 && a[i] > a[(i - 1) / 2]) { // 自下往上堆化
            swap(a, i, (i - 1) / 2); // swap()函数作用：交换下标为i和i/2的两个元素
            i = (i - 1) / 2;
        }
    }

    public Integer removeMax() {
        if (count == 0) return null;
        int res = a[0];
        a[0] = a[count - 1];
        a[count - 1] = 0;
        heapify(a, --count, 0);
        return res;
    }

    public static void sort(int[] a) {
        if (a.length <= 1) return;
        buildHeap(a);
        int k = a.length - 1;
        while (k > 0) {
            swap(a, 0, k);
            heapify(a, --k, 0);
        }
    }

    //建堆 O(n)
    private static void buildHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            heapify(a, a.length - 1, i);
        }
    }

    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i + 1 <= n && a[i] < a[i * 2 + 1]) maxPos = 2 * i + 1;
            if (2 * i + 2 <= n && a[maxPos] < a[i * 2 + 2]) maxPos = 2 * i + 2;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] a, int i, int target) {
        a[i] ^= a[target];
        a[target] ^= a[i];
        a[i] ^= a[target];
    }

    public static void main(String[] args) {
        int n = 5;
        MaxHeap heap = new MaxHeap(n);
        for (int i = 0; i < 5; i++) {
            heap.insert(i);
        }
//        sort(heap.a);
        heap.removeMax();
        for (int i : heap.a) {
            System.out.println(i);
        }
    }

}
