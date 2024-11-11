<?php

$host = "HAIIRO-NO-MAJO";
$connOptions = array(
    "Database" => "TSQL",
    "UID" => "",
    "Pwd" => ""
);

$conn = sqlsrv_connect($host, $connOptions);

if($conn) {
    echo "Koneksi Berhasil";
}else{
    die(print_r(sqlsrv_errors(), true));
}