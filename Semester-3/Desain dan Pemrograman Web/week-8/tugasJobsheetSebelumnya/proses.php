<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $nama = $_POST["nama"];
    $email = $_POST["email"];
    $subjek = $_POST["subjek"];
    $pesan = $_POST["pesan"];

    if (mail($email, $subjek, $pesan, "Dari: $nama")) {
        echo "Data berhasil dikirim: <br> Nama: $nama <br> Email: $email <br> Subjek: $subjek <br> Pesan: $pesan";
    } else {
        echo "Pengiriman kepada $email tidak berhasil";
    }
}
