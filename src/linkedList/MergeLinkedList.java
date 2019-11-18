package linkedList;

public class MergeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode merged = new MergeLinkedList().mergeTwoLists(listNode1, listNode2);
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode listNode = null;
//        while (l1 != null || l2 != null) {
//            if (l1 == null) {
//                while (l2 != null) {
//                    ListNode tempNode = listNode;
//                    listNode = l2;
//                    l2 = l2.next;
//                    listNode.next = tempNode;
//                }
//
//            } else if (l2 == null) {
//                while ((l1 != null)) {
//                    ListNode tempNode = listNode;
//                    listNode = l1;
//                    l1 = l1.next;
//                    listNode.next = tempNode;
//                }
//            } else {
//                if (l2.val < l1.val) {
//                    ListNode tempNode = listNode;
//                    listNode = l2;
//                    l2 = l2.next;
//                    listNode.next = tempNode;
//                } else {
//                    ListNode tempNode = listNode;
//                    listNode = l1;
//                    l1 = l1.next;
//                    listNode.next = tempNode;
//                }
//            }
//        }
//        ListNode prev = null;
//        ListNode curr = listNode;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }

}
