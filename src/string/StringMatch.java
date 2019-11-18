package string;

public class StringMatch {

    class Node {
        int value;
        Node prev;
        Node next;
    }
    Node first;
    Node last;
    int removeFirst() {
        Node remove = first;
        if (remove == null) {
            return -1;
        }
        first = remove.next;
        return remove.value;
    }

    int removeLast() {
        Node remove = last;
        if (remove == null) {
            return -1;
        }
        last = remove.prev;
        return remove.value;
    }


    public int[] diStringMatch(String S) {
        first = new Node();
        first.value = 0;
        Node prev = first;
        for (int i = 1; i <= S.length(); i++) {
            Node temp = new Node();
            temp.value = i;
            prev.next = temp;
            temp.prev = prev;
            prev = temp;
        }
        last = prev;
        int[] result = new int[S.length() + 1];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                result[i] = removeLast();
            } else {
                result[i] = removeFirst();
            }
        }
        int last = removeFirst();
        result[S.length()] = last == -1 ? removeLast() : last;
        return result;
    }

    public static void main(String[] args) {
        int[] result = new StringMatch().diStringMatch("IDID");
        for (int i : result) {
            System.out.println(i);

        }
    }
}
