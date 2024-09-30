<?php
$a = 10;
$b = 5;
$hasilTambah = $a + $b;
$hasilkurang = $a - $b;
$hasilkali = $a * $b;
$hasilBagi = $a / $b;
$sisaBagi = $a % $b;
$pangkat = $a ** $b;
echo "a: {$a} <br>";
echo "b: {$b} <br>";
echo "hasilTambah: {$hasilTambah} <br>";
echo "hasilkurang: {$hasilkurang} <br>";
echo "hasilkali: {$hasilkali} <br>";
echo "hasilBagi: {$hasilBagi} <br>";
echo "sisaBagi: {$sisaBagi} <br>";
echo "pangkat: {$pangkat} <br><br>";

$hasilSama = $a == $b;
$hasilTidakSama = $a != $b;
$hasilLebihKecil = $a < $b;
$hasilLebihBesar = $a > $b;
$hasilLebihKecilSama = $a <= $b;
$hasilLebihBesarSama = $a >= $b;
echo "hasilSama: {$hasilSama} <br>";
echo "hasilTidakSama: {$hasilTidakSama} <br>";
echo "hasilLebihKecil: {$hasilLebihKecil} <br>";
echo "hasilLebihBesar: {$hasilLebihBesar} <br>";
echo "hasilLebihKecilSama: {$hasilLebihKecilSama} <br>";
echo "hasilLebihBesarSama: {$hasilLebihBesarSama} <br><br>";

$hasilAnd = $a && $b;
$hasilor = $a || $b;
$hasilNotA = !$a;
$hasilNotB = !$b;
echo "hasilAnd: {$hasilAnd} <br>";
echo "hasilor: {$hasilor} <br>";
echo "hasilNotA: {$hasilNotA} <br>";
echo "hasilNotB: {$hasilNotB} <br><br>";

$a += $b;
echo "\$a += \$b: {$a} <br>";
$a -= $b;
echo "\$a -= \$b: {$a} <br>";
$a *= $b;
echo "\$a *= \$b: {$a} <br>";
$a /= $b;
echo "\$a /= \$b: {$a} <br>";
$a %= $b;
echo "\$a %= \$b: {$a} <br><br>";

$hasilIdentik = $a === $b;
$hasilTidakIdentik = $a !== $b;
echo "hasilIdentik: {$hasilIdentik} <br>";
echo "hasilTidakIdentik: {$hasilTidakIdentik} <br>";