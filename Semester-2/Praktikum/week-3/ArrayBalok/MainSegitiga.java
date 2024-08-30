package ArrayBalok;

public class MainSegitiga {
    public static void main(String[] args) {
        Segitiga[] sgArray = new Segitiga[4];
        int[][] alasTinggi = { { 10, 4 }, { 20, 10 }, { 15, 6 }, { 25, 10 } };

        for (int i = 0; i < sgArray.length; i++) {
            System.out.println("sgArray ke-" + i);
            sgArray[i] = new Segitiga(alasTinggi[i][0], alasTinggi[i][1]);
            System.out.println("Luas: " + sgArray[i].hitungLuas());
            System.out.println("Keliling: " + sgArray[i].hitungKeliling());
        }
    }
}
