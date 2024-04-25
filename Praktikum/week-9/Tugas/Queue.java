package Tugas;

public class Queue {
    Pembeli[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n) {
        max = n;
        data = new Pembeli[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");

        } else {
            int i = front;
            while (i != rear) {
                System.out.println(data[i].nama + " " + data[i].noHP);
                i = (i + 1) % max;
            }
            System.out.println(data[i].nama + " " + data[i].noHP);
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void enqueue(Pembeli dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public Pembeli dequeue() {
        Pembeli dt = new Pembeli();
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                if (front == max - 1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Elemen terdepan : " + data[front].nama + " " + data[front].noHP);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println("Elemen terdepan : " + data[rear].nama + " " + data[rear].noHP);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void peekPosition(String keyNama) {
        int i = front;
        while (i != rear) {
            if (data[i].nama.equals(keyNama)) {
                System.out.println(keyNama + " berada di antrian ke-" + (i - front + 1));
                return;
            }
            i = (i + 1) % max;
        }
        System.out.println(keyNama + " tidak ada di antrian");
    }

    public void daftarPembeli(){
        if (isEmpty()) {
            System.out.println("Queue masih kosong");

        } else {
            int i = front;
            while (i != rear) {
                System.out.println(data[i].nama + " " + data[i].noHP);
                i = (i + 1) % max;
            }
            System.out.println(data[i].nama + " " + data[i].noHP);
            System.out.println("Jumlah elemen = " + size);
        }
    }
}