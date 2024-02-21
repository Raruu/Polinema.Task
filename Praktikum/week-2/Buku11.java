
public class Buku11 {
    String judul, pengarang;
    int halaman, stok, harga;
    
    void tampilInformasi(){
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stok: " + stok);
        System.out.println("Harga Rp: " + harga);
    }

    void terjual(int jml){
        if(stok > 0){
            stok -= jml;
        }else if(stok - jml < 0){
            System.out.println("Stock tidak cukup!");
        }
        else{
            System.out.println("Stock habis!");
        }
    }

    void restock(int jml){
        stok += jml;
    }

    void gantiHarga(int hrg){
        harga = hrg;
    }
}