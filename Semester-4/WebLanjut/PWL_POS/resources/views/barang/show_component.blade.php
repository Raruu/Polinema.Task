<table class="table table-bordered table-striped table-hover table-sm">
    <tr>
        <th>ID</th>
        <td>{{ $barang->barang_id }}</td>
    </tr>
    <tr>
        <th>Kode Barang</th>
        <td>{{ $barang->barang_kode }}</td>
    </tr>
    <tr>
        <th>Nama Barang</th>
        <td>{{ $barang->barang_nama }}</td>
    </tr>
    <tr>
        <th>Harga Beli</th>
        <td>Rp. {{ $barang->harga_beli }}</td>
    </tr>
    <tr>
        <th>Harga Jual</th>
        <td>Rp. {{ $barang->harga_jual }}</td>
    </tr>
    <tr>
        <th>Kategori</th>
        <td>{{ $barang->kategori->kategori_nama }}</td>
    </tr>
</table>
