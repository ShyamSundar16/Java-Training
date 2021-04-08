package com.amzn;

/**
 * Created by Shyam Sundar on 4/7/21.
 */
public class LinkedListAddition {
    static Node head1, head2,head3;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    Node addLinkedList(Node first, Node second, Node third) {
        Node prev = null;
        Node temp = null;
        Node res = null;
        int carry = 0, sum;

        while (first != null || second != null || third !=null) {
            sum = carry+(first != null ? first.data : 0) + (second != null ? second.data : 0)+ (third != null ? third.data : 0);
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
            if (third != null) {
                third = third.next;
            }
        }
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedListAddition linkedListAddition = new LinkedListAddition();
        linkedListAddition.head1 = new Node(1);
        linkedListAddition.head1.next = new Node(3);
        linkedListAddition.head1.next.next = new Node(1);
        linkedListAddition.printList(head1);

        linkedListAddition.head2 = new Node(2);
        linkedListAddition.head2.next = new Node(4);
        linkedListAddition.head2.next.next = new Node(1);
        linkedListAddition.printList(head2);

        linkedListAddition.head3 = new Node(3);
        linkedListAddition.head3.next = new Node(6);
        linkedListAddition.head3.next.next = new Node(1);
        linkedListAddition.printList(head3);

        Node node = linkedListAddition.addLinkedList(head1, head2,head3);
        System.out.println("Result :");
        linkedListAddition.printList(node);
    }
}
