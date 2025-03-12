@extends('layouts.app')
{{-- Customize layout sections --}}
@section('subtitle', 'Kategori')
@section('content_header_title', 'Kategori')
@section('content_header_subtitle', 'Create')
{{-- Content body: main page content --}}
@section('content')
    <div class="container">
        <div class="card card-primary">
            <div class="card-header">
                <h3 class="card-title">Edit kategori</h3>
            </div>
            <div class="d-flex justify-content-between" style="padding: 10px;">
                <a href="/kategori" class="btn btn-sm btn-secondary mt-2">Kembali</a>
            </div>
            <form method="post" action="../edit">
                @csrf <!-- {{ csrf_field() }} -->
                <div class="card-body">
                    <input type="hidden" name="kategori_id" value="{{ $data->kategori_id }}">
                    <div class="form-group">
                        <label for="kodeKategori">Kode Kategori</label>
                        <input type="text" class="form-control" id="kodeKategori" name="kodeKategori"
                            placeholder="Masukan Kode Kategori" value="{{ $data->kategori_kode }}">
                    </div>
                    <div class="form-group">
                        <label for="namaKategori">Nama Kategori</label>
                        <input type="text" class="form-control" id="namaKategori" name="namaKategori"
                            placeholder="Masukan Nama Kategori" value="{{ $data->kategori_nama }}">
                    </div>
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
@endsection
