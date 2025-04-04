<div id="modal-master" class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content flex-fill">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Data Supplier</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <table class="table table-bordered table-striped table-hover table-sm">
                <tr>
                    <th>ID</th>
                    <td>{{ $supplier->supplier_id }}</td>
                </tr>
                <tr>
                    <th>Kode Supplier</th>
                    <td>{{ $supplier->supplier_kode }}</td>
                </tr>
                <tr>
                    <th>Nama Supplier</th>
                    <td>{{ $supplier->supplier_nama }}</td>
                </tr>
                <tr>
                    <th>Alamat Supplier</th>
                    <td>{{ $supplier->supplier_alamat }}</td>
                </tr>
                <tr>
                    <th>Telepon Supplier</th>
                    <td>{{ $supplier->supplier_telepon }}</td>
                </tr>
                <tr>
                    <th>Email Supplier</th>
                    <td>{{ $supplier->supplier_email }}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
