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
}
