<?php
$siswa = [
    ["Alice" , 85,],
    ["Bob" , 95],
    ["Charlie" , 78],
    ["David" , 62],
    ["Eva" , 90]
];
$totalNilai = 0;
foreach ($siswa as $nilai) {
    $totalNilai += $nilai[1];
}
$rataRata = $totalNilai / count($siswa);
echo "Siswa yang nilainya di atas rata-rata (rata-rata: $rataRata):<br>";
foreach ($siswa as $siswaNilai) {
    if ($siswaNilai[1] > $rataRata) {
        echo "$siswaNilai[0]: {$siswaNilai[1]}<br>";
    }
}
