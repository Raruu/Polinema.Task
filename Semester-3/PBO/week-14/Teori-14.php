<?php

abstract class EntitasTerbang {
    protected $nama;
    protected $jumlahSayap;

    public function __construct($nama, $jumlahSayap) {
        $this->nama = $nama;
        $this->jumlahSayap = $jumlahSayap;
    }

    abstract public function terbang();
    abstract public function mendarat();
}

abstract class Burung extends EntitasTerbang {
    protected $panjangParuh;

    public function __construct($nama, $jumlahSayap, $panjangParuh) {
        parent::__construct($nama, $jumlahSayap);
        $this->panjangParuh = $panjangParuh;
    }

    abstract public function bersuara();
}

class KakakTua extends Burung {
    public function bersuara() {
        echo "KakakTua berbunyi!\n";
    }

    public function meniruSuaraManusia() {
        echo "KakakTua meniru suara manusia!\n";
    }

    public function terbang() {
        echo "KakakTua terbang!\n";
    }

    public function mendarat() {
        echo "KakakTua mendarat!\n";
    }
}

class AyamJantan extends Burung {
    public function bersuara() {
        echo "AyamJantan berkokok: Kokok petok petok!\n";
    }

    public function berkokok() {
        echo "AyamJantan sedang berkokok!\n";
    }

    public function terbang() {
        echo "AyamJantan mencoba terbang (walaupun tidak tinggi)!\n";
    }

    public function mendarat() {
        echo "AyamJantan mendarat!\n";
    }
}

abstract class KendaraanUdara extends EntitasTerbang {
    protected $jumlahMesin;
    protected $kapasitasPenumpang;

    public function __construct($nama, $jumlahSayap, $jumlahMesin, $kapasitasPenumpang) {
        parent::__construct($nama, $jumlahSayap);
        $this->jumlahMesin = $jumlahMesin;
        $this->kapasitasPenumpang = $kapasitasPenumpang;
    }

    public function lakukanPerawatanBerkala() {
        echo "Melakukan perawatan berkala untuk $this->nama.\n";
    }
}

class PesawatTerbang extends KendaraanUdara {
    public function terbang() {
        echo "$this->nama sedang terbang!\n";
    }

    public function mendarat() {
        echo "$this->nama sedang mendarat!\n";
    }
}

class Helikopter extends KendaraanUdara {
    public function terbang() {
        echo "$this->nama sedang terbang secara vertikal!\n";
    }

    public function mendarat() {
        echo "$this->nama mendarat di tempat tertentu!\n";
    }

    public function hover() {
        echo "$this->nama melayang di udara!\n";
    }
}

$kakakTua = new KakakTua("Kakak Tua", 2, 10);
$kakakTua->bersuara();
$kakakTua->meniruSuaraManusia();

$ayamJantan = new AyamJantan("Ayam Jantan", 2, 5);
$ayamJantan->bersuara();
$ayamJantan->berkokok();

$pesawat = new PesawatTerbang("Boeing 747", 2, 4, 300);
$pesawat->terbang();
$pesawat->mendarat();
$pesawat->lakukanPerawatanBerkala();

$helikopter = new Helikopter("Apache", 0, 1, 6);
$helikopter->terbang();
$helikopter->hover();
$helikopter->lakukanPerawatanBerkala();
