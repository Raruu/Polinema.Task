<!DOCTYPE html>
<html>

<head>
    <title>Tugas Praktikum</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
        crossorigin="anonymous"></script>
</head>

<body>
    <h1>Tugas Praktikum Form</h1>
    <form id="myForm">
        <label for="nama">Nama: </label>
        <input type="text" id="nama" name="nama">
        <span id="nama-error" style="color: red;"></span><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email">
        <span id="email-error" style="color: red; "></span><br>
        <label for="subjek">Subjek: </label>
        <input type="text" id="subjek" name="subjek">
        <span id="subjek-error" style="color: red; "></span><br>
        <label for="pesan">Pesan: </label> <br>
        <textarea type="textarea" id="pesan" name="pesan" rows="10" cols="50"></textarea>
        <br>
        <input type="submit" value="Submit">
    </form>
    <div id="hasil">
    </div>
    <script>
        function validateEmailNotValid(email) {
            const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return !re.test(String(email).toLowerCase());
        }

        $(document).ready(function() {
            $("#myForm").submit(function(event) {
                event.preventDefault();
                var nama = $("#nama").val();
                var email = $("#email").val();
                var valid = true;
                if (nama.length < 3) {
                    $("#nama-error").text("Nama minimal 3 karakter.");
                    valid = false;
                } else {
                    $("#nama-error").text("");
                }
                if (validateEmailNotValid(email)) {
                    $("#email-error").text("Email tidak valid.");
                    valid = false;
                } else {
                    $("#email-error").text("");
                }
                var subjek = $("#subjek").val();
                if (subjek === "") {
                    $("#subjek-error").text("Subjek tidak boleh kosong.");
                    valid = false;
                } else {
                    $("#subjek-error").text("");
                }

                if (valid) {
                    var formData = $("#myForm").serialize();
                    $.ajax({
                        url: "proses.php",
                        type: "POST",
                        data: formData,
                        success: function(response) {
                            $("#hasil").html(response);
                        }
                    });
                } else {
                    $("#hasil").text("");
                }
            });
        });
    </script>
</body>

</html>