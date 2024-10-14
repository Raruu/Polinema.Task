package TugasOverloading;

public class Segitiga {
    private int sudut;

    public int totalSudut(int sudutA) {
        return 180 - sudutA;
    }

    public int totalSudut(int sudutA, int sudutB) {
        return 180 - (sudutA - sudutB);
    }

    public int keliling(int sisiA, int sisiB, int sisaC) {
        return sisiA + sisiB + sisaC;
    }

    public double keliling(int sisiA, int sisiB) {
        return sisiA + sisiB + (Math.sqrt(Math.pow(sisiA, 2)) + Math.sqrt(Math.pow(sisiB, 2)));
    }

    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();
        System.out.println("totalSudut(int sudutA): " + segitiga.totalSudut(90));
        System.out.println("totalSudut(int sudutA, int sudutB): " + segitiga.totalSudut(45, 90));
        System.out.println("keliling(int sisiA, int sisiB, int sisaC): " + segitiga.keliling(45, 45, 45));
        System.out.println("keliling(int sisiA, int sisiB): " + segitiga.keliling(30, 45));
    }
}
