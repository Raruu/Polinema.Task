<?php
$siswa = [
    [
        'nama' => 'Kuma',
        'kursus' => ['Pemrograman Web', 'Desain Grafis']
    ],
    [
        'nama' => 'Nyan',
        'kursus' => ['Pemrograman Mobile', 'Bahasa Inggris']
    ]
];

function tampilkanSiswa()
{
    global $siswa;
    foreach ($siswa as $s) {
        echo "Nama: " . $s['nama'] . "<br>";
        echo "Kursus: ";
        foreach ($s['kursus'] as $kursus) {
            echo $kursus . ", ";
        }
        echo "<br>";
    }
}

function tambahSiswa($nama, $kursus)
{
    global $siswa;
    $siswa[] = [
        'nama' => $nama,
        'kursus' => $kursus
    ];
}

echo "Sebelum Ditambah:<br>";
tampilkanSiswa();
echo "<br>Setelah Ditambah:<br>";
tambahSiswa('Citra', ['Bahasa Inggris', 'Pemrograman Web']);
tampilkanSiswa();
