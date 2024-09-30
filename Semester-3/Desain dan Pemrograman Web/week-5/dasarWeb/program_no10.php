<!DOCTYPE html>
<html>

<head>
    <title>Program No 10</title>
</head>

<body>
    <h2>Program No 10</h2>
    <h4>
        Buatlah program yang meminta input dua bilangan dari pengguna. Program ini harus melakukan
        operasi berikut:
        • Penjumlahan <br>
        • Pengurangan <br>
        • Perkalian <br>
        • Pembagian <br>
        Tampilkan hasil dari setiap operasi.
    </h4>
    <form method="post">
        Bilangan a: <input type="number" name="var_a"><br>
        Bilangan b: <input type="number" name="var_b"><br>
        <input type="submit" value="Hitung">
    </form>
    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $var_a = $_POST['var_a'];
        $var_b = $_POST['var_b'];
        $penjumlahan = $var_a + $var_b;
        $pengurangan = $var_a - $var_b;
        $perkalian = $var_a * $var_b;
        $pembagian = $var_a / $var_b;
        echo "Hasil penjumlahan $var_a dan $var_b adalah $penjumlahan.<br>";
        echo "Hasil pengurangan $var_a dan $var_b adalah $pengurangan.<br>";
        echo "Hasil perkalian $var_a dan $var_b adalah $perkalian.<br>";
        echo "Hasil pembagian $var_a dan $var_b adalah $pembagian.<br>";
    }
    ?>
</body>

</html>