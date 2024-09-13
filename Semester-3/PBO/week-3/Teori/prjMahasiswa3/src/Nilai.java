public class Nilai {
    private String namaMatakuliah, nilaiHuruf;
    private int sks;
    private double nilaiTugas, nilaiUTS, nilaiUAS;


    public Nilai(String namaMatakuliah, int sks, double nilaiTugas, double nilaiUTS, double nilaiUAS) {
        this.namaMatakuliah = namaMatakuliah;
        this.sks = sks;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        nilaiHuruf = getNilaiHuruf((nilaiTugas + nilaiUTS + nilaiUAS) / 3);
    }

    private String getNilaiHuruf(double nilai) {
        if (nilai >= 85) {
            return "A";
        } else if (nilai >= 75) {
            return "B+";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 60) {
            return "C+";
        } else if (nilai >= 55) {
            return "C";
        }
        return "D";
    }

    private double getNilaiAngka() {
        return switch (nilaiHuruf) {
            case "A" -> 4.0;
            case "B+" -> 3.5;
            case "B" -> 3.0;
            case "C+" -> 2.5;
            case "C" -> 2.0;
            default -> 1.0;
        };
    }

    public static double getIPS(Nilai[] nilais) {
        int totalSKS = 0;
        double sigmaNilaiSKS = 0.0;
        for (Nilai i : nilais) {
            totalSKS += i.sks;
            sigmaNilaiSKS += i.sks * i.getNilaiAngka();
        }
        sigmaNilaiSKS /= totalSKS;
        return sigmaNilaiSKS;
    }

    public static void printKHS(Nilai[] nilais) {
        System.out.println("KHS");
        for (Nilai i : nilais) {
            System.out.println(i.namaMatakuliah + ": ");
            System.out.println("Nilai Tugas: " + i.nilaiTugas);
            System.out.println("Nilai UTS: " + i.nilaiUTS);
            System.out.println("Nilai UA: " + i.nilaiUAS);
            System.out.println("Nilai Huruf: " + i.nilaiHuruf);
            System.out.println("Nilai Angka: " + i.getNilaiAngka());
        }
        System.out.println("Index Prestasi Semester (IPS): " + Nilai.getIPS(nilais));
    }
}
