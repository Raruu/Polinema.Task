<?php
$connect = mysqli_connect("localhost", "root", "", "prakwebdb");

if ($connect) {
    echo "Koneksi dengan MySql berhasil";
}
else {
    echo "Koneksi dengan MySql gagal" . mysqli_connect_error($connect);
}
echo "<br><br>";