<?php
$koneksi = mysqli_connect("localhost", "root", "", "prakwebdb");

if (!$koneksi) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

$sql = "INSERT INTO user (`id`, `username`, `password`) VALUES ('1', 'admin', MD5('123'))";


if (mysqli_query($koneksi, $sql)) {
    echo "berhasil";
} else {
    echo "gagal";
}

mysqli_close($koneksi);
