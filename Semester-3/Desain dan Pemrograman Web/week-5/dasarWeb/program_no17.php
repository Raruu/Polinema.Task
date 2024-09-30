<?php
$hargaAwal = 120000;
$jumlahDiskon = 0;
if ($hargaAwal > 100000) {
    $diskon = 20;
    $jumlahDiskon = ($hargaAwal * $diskon) / 100;
}
$hargaAkhir = $hargaAwal - $jumlahDiskon;
echo "Harga awal yang harus dibayar adalah Rp " . $hargaAwal . "<br>";
echo "Harga akhir yang harus dibayar adalah Rp " . $hargaAkhir;
