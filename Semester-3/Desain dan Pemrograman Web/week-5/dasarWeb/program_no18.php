<?php
$batasSkorHadiah = 500;
$totalSkor = 400;
$dapatHadiah = ($totalSkor > $batasSkorHadiah) ? "YA" : "TIDAK";
echo "Total skor pemain adalah: " . $totalSkor . "<br>";
echo "Apakah pemain mendapatkan hadiah tambahan? " . $dapatHadiah;