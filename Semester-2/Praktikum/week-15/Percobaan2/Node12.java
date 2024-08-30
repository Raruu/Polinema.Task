package Percobaan2;

public class Node12 {
    int data;
    Node12 prev, next;
    int jarak;

    Node12(Node12 prev, int data, int jarak, Node12 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
        this.jarak = jarak;
    }
}
