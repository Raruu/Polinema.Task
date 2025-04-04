<form action="{{ url('/supplier/ajax') }}" method="POST" id="form-tambah" class="modal-dialog-centered">
    @csrf
    <div id="modal-master" class="modal-dialog modal-lg flex-fill" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Tambah Data Supplier</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Supplier Kode</label>
                    <input value="" type="text" name="supplier_kode" id="supplier_kode" class="form-control"
                        required>
                    <small id="error-supplier-kode" class="error-text form-text text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Supplier Nama</label>
                    <input value="" type="text" name="supplier_nama" id="supplier_nama" class="form-control"
                        required>
                    <small id="error-supplier-nama" class="error-text form-text text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Supplier Alamat</label>
                    <input value="" type="text" name="supplier_alamat" id="supplier_alamat"
                        class="form-control" required>
                    <small id="error-supplier-alamat" class="error-text form-text text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Supplier Telepon</label>
                    <input value="" type="text" name="supplier_telepon" id="supplier_telepon"
                        class="form-control" required>
                    <small id="error-supplier-telepon" class="error-text form-text text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Supplier Email</label>
                    <input value="" type="text" name="supplier_email" id="supplier_email" class="form-control"
                        required>
                    <small id="error-supplier-email" class="error-text form-text text-danger"></small>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn btn-default">Batal</button>
                <button type="submit" class="btn btn-primary">Simpan</button>
            </div>
        </div>
    </div>
</form>
<script>
    $(document).ready(function() {
        $("#form-tambah").validate({
            rules: {
                supplier_kode: {
                    required: true,
                    minlength: 7,
                    maxlength: 10
                },
                supplier_nama: {
                    required: true,
                    maxlength: 100
                },
                supplier_alamat: {
                    required: true
                },
                supplier_telepon: {
                    required: true
                },
                supplier_email: {
                    required: true
                }
            },
            submitHandler: function(form) {
                $.ajax({
                    url: form.action,
                    type: form.method,
                    data: $(form).serialize(),
                    success: function(response) {
                        if (response.status) {
                            $('#myModal').modal('hide');
                            Swal.fire({
                                icon: 'success',
                                title: 'Berhasil',
                                text: response.message
                            });
                            dataUser.ajax.reload();
                        } else {
                            $('.error-text').text('');
                            $.each(response.msgField, function(prefix, val) {
                                $('#error-' + prefix).text(val[0]);
                            });
                            Swal.fire({
                                icon: 'error',
                                title: 'Terjadi Kesalahan',
                                text: response.message
                            });
                        }
                    }
                });
                return false;
            },
            errorElement: 'span',
            errorPlacement: function(error, element) {
                error.addClass('invalid-feedback');
                element.closest('.form-group').append(error);
            },
            highlight: function(element, errorClass, validClass) {
                $(element).addClass('is-invalid');
            },
            unhighlight: function(element, errorClass, validClass) {
                $(element).removeClass('is-invalid');
            }
        });
    });
</script>
