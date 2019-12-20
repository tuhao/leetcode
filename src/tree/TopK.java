package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TopK {


    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int minPos = i;
            if (2 * i + 1 <= n && a[i] > a[2 * i + 1]) minPos = 2 * i + 1;
            if (2 * i + 2 <= n && a[minPos] > a[2 * i + 2]) minPos = 2 * i + 2;
            if (minPos == i) break;
            swap(a, i, minPos);
            i = minPos;
        }
    }

    private static void swap(int[] a, int i, int target) {
        a[i] ^= a[target];
        a[target] ^= a[i];
        a[i] ^= a[target];
    }


    public static void buildHeap(int[] a) {
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            heapify(a, a.length - 1, i);
        }
    }

    //Top K
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int n = 10;
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        int k = 3;
        int[] a = new int[k];

        for (int i = 0; i < k; i++) {
            a[i] = list.get(i);
        }
        buildHeap(a);
        for (int i = k; i < list.size(); i++) {
            Integer data = list.get(i);
            if (data > a[0]) {
                a[0] = data;
                buildHeap(a);
            }
        }
        list.forEach(item -> System.out.print(item + " "));
        System.out.println();
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
