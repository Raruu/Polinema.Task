<!DOCTYPE html>
<html>
<head>
    <title>Hitung Luas Lingkaran</title>
</head>
<body>
    <h2>Hitung Luas Lingkaran</h2>
    <form method="post">
        Masukkan jari-jari lingkaran: <input type="number" name="jari_jari"><br>
        <input type="submit" value="Hitung">
    </form>
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $jariJari = $_POST['jari_jari'];
        define('PI', 3.14);
        $luas = PI * $jariJari * $jariJari;
        echo "Luas lingkaran dengan jari-jari $jariJari adalah: $luas";
    }
    ?>
</body>
</html>