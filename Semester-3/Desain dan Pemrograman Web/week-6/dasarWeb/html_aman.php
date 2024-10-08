<?php
$input = "<script>alert('You have been hacked!'); </script>";
$input = htmlspecialchars($input, ENT_QUOTES, 'UTF-8');
echo $input;
echo '<br>';

// Memeriksa apakah input adalah email yang valid
$email = "widigmail.com";
if (filter_var($email, FILTER_VALIDATE_EMAIL)) {
    echo "Email yang valid: " . $email;
} else {
    echo "Email yang tidak valid: " . $email;
}
