@extends('layouts.template')
@section('content')
    <div class="card card-outline card-primary">
        <div class="card-header">
            <h3 class="card-title">{{ $page->title }}</h3>
            <div class="card-tools"></div>
        </div>
        <div class="card-body">
            @empty($user)
                <div class="alert alert-danger alert-dismissible">
                    <h5><i class="icon fas fa-ban"></i> Kesalahan!</h5>
                    Data yang Anda cari tidak ditemukan.
                </div>
                <a href="{{ url('user') }}" class="btn btn-sm btn-default mt2">Kembali</a>
            @else
                <form method="POST" action="{{ url('/user/' . $user->user_id) }}" class="form-horizontal"
                    enctype="multipart/form-data">@csrf
                    {!! method_field('PUT') !!}
                    <div class="form-group text-center">
                        <label for="profile_picture" class="position-relative"
                            style="width: 150px; height: 150px; clip-path: circle(50% at 50% 50%);">
                            <img src="{{ $user->picture_path ?? asset('profile_placeholder.jpg') }}?{{ now() }}"
                                alt="Profile Picture" class="w-100">
                            <div class="overlay rounded-circle position-absolute w-100 h-100"
                                style="opacity: 0; transition: opacity 0.15s; cursor: pointer; top: 50%; left: 50%; transform: translate(-50%, -50%);"
                                onmouseover="this.style.opacity = 1;" onmouseout="this.style.opacity = 0;">
                                <i class="fas fa-upload position-absolute text-white"
                                    style="top: 50%; left: 50%; transform: translate(-50%, -50%);"></i>
                            </div>
                        </label>
                        <input type="file" name="profile_picture" id="profile_picture" class="d-none"
                            accept="image/jpeg, image/jpg, image/png"
                            onchange="this.parentNode.querySelector('label').querySelector('img').src = window.URL.createObjectURL(this.files[0]);">
                        <small id="error-profile_picture" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group @if (Auth::user()->getRole() != 'ADM') d-none @endif">
                        <label>Level Pengguna</label>
                        <select name="level_id" id="level_id" class="form-control" required>
                            <option value="">- Pilih Level -</option>
                            @foreach ($level as $l)
                                <option value="{{ $l->level_id }}" {{ $l->level_id == $user->level_id ? 'selected' : '' }}>
                                    {{ $l->level_nama }}</option>
                            @endforeach
                        </select>
                        <small id="error-level_id" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label>Username</label>
                        <input value="{{ $user->username }}" type="text" name="username" id="username" class="form-control"
                            required>
                        @error('username')
                            <small class="form-text text-danger">{{ $message }}</small>
                        @enderror
                        <small id="error-username" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label>Nama</label>
                        <input value="{{ $user->nama }}" type="text" name="nama" id="nama" class="form-control"
                            required>
                        @error('nama')
                            <small class="form-text text-danger">{{ $message }}</small>
                        @enderror
                        <small id="error-nama" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input value="{{ $user->email }}" type="email" name="email" id="email" class="form-control">
                        @error('email')
                            <small class="form-text text-danger">{{ $message }}</small>
                        @enderror
                        <small id="error-email" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label>Nomor Telp</label>
                        <input value="{{ $user->no_telepon }}" type="number" name="no_telepon" id="no_telepon"
                            class="form-control">
                        @error('no_telepon')
                            <small class="form-text text-danger">{{ $message }}</small>
                        @enderror
                        <small id="error-no_telepon" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" id="password" class="form-control">
                        <small class="form-text text-muted">Abaikan jika tidak ingin ubah password</small>
                        @error('password')
                            <small class="form-text text-danger">{{ $message }}</small>
                        @enderror
                        <small id="error-password" class="error-text form-text text-danger"></small>
                    </div>
                    <div class="form-group row">
                        <div class="col-11">
                            <button type="submit" class="btn btn-primary btn-sm">Simpan</button>
                            <a class="btn btn-sm btn-default ml-1" href="{{ url('user') }}">Kembali</a>
                        </div>
                    </div>
                </form>
            @endempty
        </div>
    </div>
@endsection
@push('css')
@endpush
@push('js')
@endpush
