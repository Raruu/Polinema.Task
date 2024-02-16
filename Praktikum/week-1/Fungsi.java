public class Fungsi {
    /////////////////////////////////////////////////////////////////////
    // Fungsi Yang Ditanya
    /////////////////////////////////////////////////////////////////////
    // 1.
    public static void printPendapatanAll(String[] labelBaris, String[] labelKolom, long[][] data, long[] harga) {
        long[][] arr = new long[data.length][harga.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getPendapatan(data[i], harga);
            long total = 0;
            for (long j : arr[i]) {
                total += j;
            }
            arr[i] = addElementArray(arr[i], total);
        }

        labelKolom = addElementArray(labelKolom, "TOTAL");
        printTabel(labelBaris, labelKolom, arr);
    }

    // 2.
    public static void printDataAndMati(String[] labelBaris, String[] labelKolom, long[][] data, long[] dataMati,
            int index) {
        System.out.println("====== Stock Asli pada " + labelBaris[index] + " ======");
        printTabel(new String[] { labelBaris[index] }, labelKolom, new long[][] { data[index] });

        System.out.println("====== Stock yang mati ======");
        printTabel(new String[] { labelBaris[index] }, labelKolom, new long[][] { dataMati });

        System.out.println("====== Setelah Pengurangan dengan stock yang mati ======");
        long[] newData = new long[data[index].length];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = data[index][i] - dataMati[i];
        }
        printTabel(new String[] { labelBaris[index] }, labelKolom, new long[][] { newData });
    }

    /////////////////////////////////////////////////////////////////////
    // Fungsi yang dipisah-pisah
    /////////////////////////////////////////////////////////////////////
    public static long[] getPendapatan(long[] stock, long[] harga) {
        long[] arr = new long[harga.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stock[i] * harga[i];
        }
        return arr;
    }

    public static void printTabel(String[] labelBaris, String[] labelKolom, long[][] data) {
        System.out.print(" ".repeat(labelBaris[0].length()) + "\t");
        for (int i = 0; i < labelKolom.length; i++) {
            System.out.print(labelKolom[i] + "  ");
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            System.out.print(labelBaris[i] + "\t");
            for (int j = 0; j < data[i].length; j++) {
                String s = String.valueOf(data[i][j]);
                System.out.print(s);
                int space = labelKolom[j].length() - s.length() + 2;
                if (space > 0) {
                    System.out.print(" ".repeat(space));
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static long[] addElementArray(long[] arr, long... values) {
        long[] arrayTemp = new long[arr.length + values.length];
        for (int i = 0; i < arr.length; i++) {
            arrayTemp[i] = arr[i];
        }
        for (int i = arr.length; i < arr.length + values.length; i++) {
            arrayTemp[i] = values[i - arr.length];
        }
        return arrayTemp;
    }

    public static String[] addElementArray(String[] arr, String... values) {
        String[] arrayTemp = new String[arr.length + values.length];
        for (int i = 0; i < arr.length; i++) {
            arrayTemp[i] = arr[i];
        }
        for (int i = arr.length; i < arr.length + values.length; i++) {
            arrayTemp[i] = values[i - arr.length];
        }
        return arrayTemp;
    }

    public static void main(String[] args) {
        // Data
        String[] labelData = { "Aglonema", "Keladi", "Alocasia", "Mawar" };
        long[] harga = { 75000, 50000, 60000, 10000 };
        long[][] data = { { 10, 5, 15, 7 }, { 6, 11, 9, 12 }, { 2, 10, 10, 5 }, { 5, 7, 12, 9 } };
        String[] cabangs = new String[data.length];
        for (int i = 0; i < cabangs.length; i++) {
            cabangs[i] = "RoyalGarden" + (i + 1);
        }

        // Print Data mentah
        System.out.println("====== Data Mentah ======");
        printTabel(cabangs, labelData, data);

        // Buatlah fungsi untuk menampilkan pendapatan setiap cabang jika semua bunga
        // habis terjual.
        String separator = "==================================";
        System.out.println(separator + "\nPertanyaan no 1\n" + separator);
        System.out.println("====== Data Keuntugan Total (semua cabang) ======");
        printPendapatanAll(cabangs, labelData, data, harga);

        // Buatlah fungsi untuk mengetahui jumlah Stock setiap jenis bunga pada cabang
        // royalgarden 4.
        // Jika terdapat informasi tambahan berupa pengurangan stock karena bunga
        // tersebut mati.
        // Dengan rincian Aglonema -1, Keladi -2, Alocasia -0, Mawar -5.
        System.out.println(separator + "\nPertanyaan no 2\n" + separator);
        long[] bungaMati = { 1, 2, 0, 5 };
        printDataAndMati(cabangs, labelData, data, bungaMati, 3);
    }
}
