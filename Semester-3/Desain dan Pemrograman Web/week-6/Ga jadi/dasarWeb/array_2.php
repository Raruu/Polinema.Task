<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: red;
        }
    </style>
</head>

<body>
    <?php
    $Dosen = [
        'nama' => 'Elok Nur Hamdana',
        'domisili' => 'Malang',
        'jenis_kelamin' => 'Perempuan'
    ];
    echo "Nama: {$Dosen['nama']} <br>";
    echo "Domisili: {$Dosen['domisili']} <br>";
    echo "Jenis Kelamin : {$Dosen['jenis_kelamin']} <br>";
    ?>
</body>

</html>