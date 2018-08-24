package com.practise.algo.entity;

public class SingleLinkedList {

    private Node head;

    /*
        Return Head
     */
    public Node addAtHead(Node node) {

        if (head == null) {
            head = node;
            return head;
        }

        node.setNext(head);
        head = node;

        return head;
    }

    /*
        Add At tail
     */

    public Node addAtTail(Node node) {
        if (head == null) {
            head = node;
            return head;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(node);

        return head;
    }

    /*
    Return deleted node
     */
    public Node deleteFromHead() {
        if (head == null) {
            return head;
        }

        Node current = head;
        current.setNext(null);

        head = head.getNext();

        return current;
    }

    /*
        Return deleted node
     */
    public  Node deleteFromTail() {
        Node current = head;
        Node prev = head;
        while (current.getNext() != null) {
            prev = current;
            current = current.getNext();
        }

        prev.setNext(null);

        return current;
    }

    /*
        Search for an value in the list
     */

    public Node search(int val) {

        Node current = head;

        while (current != null) {
            if (current.getValue() == val) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    public Node search(Node val) {

        Node current = head;

        while (current != null) {
            if (current.getValue() == val.getValue()) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    public void printList() {
        Node current = head;

        while (current != null) {

            System.out.print(current.getValue() + " --> ");
            current = current.getNext();
        }

        System.out.print("null");

    }
}
