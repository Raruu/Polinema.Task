<!DOCTYPE html>
<html>

<head>
    <title>Add Item</title>
</head>

<body>
    <h1>Add Item</h1>
    <!-- form untuk menambahkan item dengan method POST -->
    <form action="{{ route('items.store') }}" method="POST">
        <!-- token csrf untuk mengamankan form -->
        @csrf

        <!-- field untuk nama item -->
        <label for="name">Name:</label>
        <input type="text" name="name" required>
        <br>

        <!-- field untuk deskripsi item -->
        <label for="description">Description:</label>
        <textarea name="description" required></textarea>
        <br>

        <!-- tombol untuk menambahkan item -->
        <button type="submit">Add Item</button>
    </form>

    <!-- link untuk kembali ke halaman list -->
    <a href="{{ route('items.index') }}">Back to List</a>
</body>

</html>
