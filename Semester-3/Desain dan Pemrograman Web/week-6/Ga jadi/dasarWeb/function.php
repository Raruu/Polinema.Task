<?php
function perkenalan($nama, $salam = "Assalamualaikum")
{
    echo $salam . ", ";
    echo "Perkenalkan, nama saya " . $nama . "<br/>";
    echo "Senang berkenalan dengan Anda<br/>";
}
perkenalan("Hamdana", "Hallo");
echo "<hr/>";
$saya = "Widi";
$ucapSalam = "Selamat Pagi";
perkenalan($saya);
