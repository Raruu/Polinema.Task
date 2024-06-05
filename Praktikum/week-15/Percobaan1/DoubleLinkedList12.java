package Percobaan1;

public class DoubleLinkedList12 {
    Node12 head;
    int size;

    public DoubleLinkedList12() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int item, int jarak) {
        if (isEmpty()) {
            head = new Node12(null, item, jarak, null);
        } else {
            Node12 newNode12 = new Node12(null, item, jarak, head);
            head.prev = newNode12;
            head = newNode12;
        }
        size++;
    }

    public void addLast(int item, int jarak) {
        if (isEmpty()) {
            addFirst(item, jarak);
        } else {
            Node12 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node12 newNode12 = new Node12(current, item, jarak, null);
            current.next = newNode12;
            size++;
        }
    }

    public void add(int data, int jarak, int index)  {
        if (isEmpty()) {
            addFirst(data, jarak);
        } else if (index < 0 || index > size) {
            // throw new Exception("Nilai index di luar batas");
        } else {
            Node12 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                Node12 newNode12 = new Node12(null, data, jarak, current);
                current.prev = newNode12;
                head = newNode12;
            } else {
                Node12 newNode12 = new Node12(current.prev, data, jarak, current);
                System.out.println(current.prev.data+"a");
                newNode12.prev = current.prev;
                newNode12.next = current;
                newNode12.prev.next = newNode12;
                current.prev = newNode12;
                System.out.println(current.prev.prev.data+"b");
            }
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node12 tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");

        } else {
            System.out.println("Linked List kosong");
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            // throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            // throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node12 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove(int index) {
       Node12 current = head;
       while (current != null) {
            if (current.data == index) {
                if(current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if(current.next != null) {
                    current.next.prev = current.prev;
                }
                break;
            }
            current = current.next;
       }
       size--;
    }

    public int getFirst()  {
        if (isEmpty()) {
            // throw new Exception("Linked List kosong");
        }
        return head.data;
    }

    public int getLast()  {
        if (isEmpty()) {
            // throw new Exception("Linked List kosong");
        }
        Node12 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int get(int index) {
        if (isEmpty() || index >= size) {
            // throw new Exception("Nilai indeks di luar batas.");
        }
        Node12 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int getJarak(int index) {
        if (isEmpty() || index >= size) {
            // throw new Exception("Nilai indeks di luar batas");
        }
        Node12 tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.jarak;
    }
}
