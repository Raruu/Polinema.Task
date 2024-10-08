<!DOCTYPE html>
<html>
<head>
    <title>Form Input dengan Validasi</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"
        integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
        crossorigin="anonymous"></script>
</head>
<body>
    <h1>Form Input dengan Validasi</h1>
    <form id="myForm">
        <label for="nama">Nama: </label>
        <input type="text" id="nama" name="nama">
        <span id="nama-error" style="color: red;"></span><br>
        <label for="email">Email:</label>
        <input type="text" id="email" name="email">
        <span id="email-error" style="color: red; "></span><br>
        <label for="nama">Password: </label>
        <input type="text" id="passwd" name="passwd">
        <span id="passwd-error" style="color: red; "></span><br>
        <input type="submit" value="Submit">
    </form>
    <div id="hasil">
    </div>
    <script>
        $(document).ready(function() {
            $("#myForm").submit(function(event) {
                event.preventDefault();
                var nama = $("#nama").val();
                var email = $("#email").val();
                var valid = true;
                if (nama === "") {
                    $("#nama-error").text("Nama harus diisi.");
                    valid = false;
                } else {
                    $("#nama-error").text("");
                }
                if (email === "") {
                    $("#email-error").text("Email harus diisi.");
                    valid = false;
                } else {
                    $("#email-error").text("");
                }
                var passwd = $("#passwd").val();
                if (passwd.length < 8) {
                    $("#passwd-error").text("Password minimal 8 karakter.");
                    valid = false;
                } else {
                    $("#passwd-error").text("");
                }
                if (valid) {
                    var formData = $("#myForm").serialize();
                    $.ajax({
                        url: "proses_validasi.php",
                        type: "POST",
                        data: formData,
                        success: function(response) {
                            $("#hasil").html(response);
                        }
                    });
                } 
                else {
                    $("#hasil").text("");
                }
            });
        });
    </script>
</body>

</html>