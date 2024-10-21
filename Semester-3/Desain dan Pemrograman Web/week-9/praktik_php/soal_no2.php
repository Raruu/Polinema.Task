<?php
$koneksi = mysqli_connect("localhost", "root", "", "prakwebdb");

if (!$koneksi) {
    die("Koneksi gagal: " . mysqli_connect_error());
}

$sql = "CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
)";

if (mysqli_query($koneksi, $sql)) {
    echo "berhasil";
} else {
    echo "gagal";
}

mysqli_close($koneksi);
