package linkedList;

public class RemoveNthFromEndIOfList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
            if (first == null) {
                return dummy.next;
            }
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode curr = head;
//        ListNode prev = null;
//        ListNode delete = null;
//        int index = 0;
//        while (curr != null) {
//            curr = curr.next;
//            if (index++ == n) {
//                delete = head;
//            }
//            if (delete != null) {
//                prev = delete;
//                delete = delete.next;
//            }
//        }
//        prev.next = delete.next;
//        return head;
//    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode result = new RemoveNthFromEndIOfList().removeNthFromEnd(listNode, 1);
        while (result != null) {
            System.out.println(result);
            result = result.next;
        }
    }

}
