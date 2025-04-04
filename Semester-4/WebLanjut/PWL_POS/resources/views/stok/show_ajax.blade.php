<div id="modal-master" class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content flex-fill">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Data Stok</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <table class="table table-bordered table-striped table-hover table-sm">
                <tr>
                    <th>ID Stok</th>
                    <td>{{ $stok->stok_id }}</td>
                </tr>
                <tr>
                    <th>ID Barang</th>
                    <td>{{ $stok->barang_id }}</td>
                </tr>
                <tr>
                    <th>Nama Barang</th>
                    <td>{{ $stok->barang->barang_nama }}</td>
                </tr>
                <tr>
                    <th>ID User</th>
                    <td>{{ $stok->user_id }}</td>
                </tr>
                <tr>
                    <th>Stok Tanggal</th>
                    <td>{{ $stok->stok_tanggal }}</td>
                </tr>
                <tr>
                    <th>Stok Jumlah</th>
                    <td>{{ $stok->stok_jumlah }}</td>
                </tr>
            </table>
    </div>
</div>