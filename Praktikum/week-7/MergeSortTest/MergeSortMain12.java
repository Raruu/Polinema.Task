package MergeSortTest;

public class MergeSortMain12 {
    public static void main(String[] args) {
        int[] data = {10, 40, 30, 50, 70, 20, 100, 90};
        System.out.println("sorting dengan merge sort");
        MergeSorting12 mSort = new MergeSorting12();
        System.out.println("data awal");
        mSort.printArray(data);
        data = mSort.mergeSort(data);
        System.out.println("setelah diurutkan");
        mSort.printArray(data);
    }
}
