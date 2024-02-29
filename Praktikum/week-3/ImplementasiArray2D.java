public class ImplementasiArray2D {
    public static void main(String[] args) {
        PersegiPanjang[][] ppArray = new PersegiPanjang[3][2];

        for (int i = 0; i < ppArray.length; i++) {
            for (int j = 0; j < ppArray[i].length; j++) {
                ppArray[i][j] = new PersegiPanjang();
            }
        }
    }
}
