<!DOCTYPE html>
<html>

<head>
    <title>Edit Item</title>
</head>

<body>
    <h1>Edit Item</h1>
    <!-- Form untuk mengedit item -->
    <form action="{{ route('items.update', $item) }}" method="POST">
        <!-- Token CSRF untuk mengamankan form -->
        @csrf
        <!-- Menggunakan method PUT untuk pembaruan -->
        @method('PUT')
        
        <!-- Field untuk nama item -->
        <label for="name">Name:</label>
        <input type="text" name="name" value="{{ $item->name }}" required>
        <br>
        
        <!-- Field untuk deskripsi item -->
        <label for="description">Description:</label>
        <textarea name="description" required>{{ $item->description }}</textarea>
        <br>
        
        <!-- Tombol untuk memperbarui item -->
        <button type="submit">Update Item</button>
    </form>
    
    <!-- Link untuk kembali ke halaman list -->
    <a href="{{ route('items.index') }}">Back to List</a>
</body>

</html>
