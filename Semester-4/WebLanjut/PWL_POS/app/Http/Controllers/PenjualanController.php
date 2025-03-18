<?php

namespace App\Http\Controllers;

use App\DataTables\PenjualanDataTable;
use App\Models\PenjualanModel;
use App\Models\UserModel;
use Illuminate\Http\Request;

class PenjualanController extends Controller
{
    public function index()
    {
        $breadcrumb = (object)[
            'title' => 'Daftar Penjualan',
            'list' => ['Home', 'Penjualan']
        ];

        $page = (object)[
            'title' => 'Daftar penjualan yang terdaftar dalam sistem'
        ];

        $activeMenu = 'penjualan';

        return view('penjualan.index', ['breadcrumb' => $breadcrumb, 'page' => $page, 'activeMenu' => $activeMenu]);
    }

    // Ambil data penjualan dalam bentuk json untuk datatables
    public function list(PenjualanDataTable $dataTable)
    {
        return $dataTable->render();
    }

    // Menampilkan halaman form tambah penjualan
    public function create()
    {
        $breadcrumb = (object) [
            'title' => 'Tambah Penjualan',
            'list' => ['Home', 'Penjualan', 'Tambah']
        ];

        $page = (object) [
            'title' => 'Tambah penjualan baru'
        ];

        $user = UserModel::all();
        $activeMenu = 'penjualan'; // set menu yang sedang aktif

        return view('penjualan.create', [
            'breadcrumb' => $breadcrumb,
            'page' => $page,
            'user' => $user,
            'activeMenu' => $activeMenu
        ]);
    }

    // Menyimpan data penjualan baru
    public function store(Request $request)
    {
        $request->validate([
            'user_id' => 'required|integer',
            // 'pembeli' => 'required|string|max:50',
            'penjualan_kode' => 'required|string|max:20|unique:t_penjualan,penjualan_kode',
            'penjualan_tanggal' => 'required|date',
        ]);

        $pembeli = UserModel::find($request->user_id)->nama;
        PenjualanModel::create([
            'user_id' => $request->user_id,
            'pembeli' => $pembeli,
            'penjualan_kode' => $request->penjualan_kode,
            'penjualan_tanggal' => $request->penjualan_tanggal,
        ]);

        return redirect('/penjualan')->with('success', 'Data penjualan berhasil disimpan');
    }

    // Menampilkan detail penjualan
    public function show(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);

        $breadcrumb = (object) [
            'title' => 'Detail penjualan',
            'list' => ['Home', 'Penjualan', 'Detail']
        ];

        $page = (object) [
            'title' => 'Detail penjualan'
        ];

        $activeMenu = 'penjualan'; // set menu yang sedang aktif

        return view('penjualan.show', [
            'breadcrumb' => $breadcrumb,
            'page' => $page,
            'penjualan' => $penjualan,
            'activeMenu' => $activeMenu
        ]);
    }

    // Menampilkan halaman form edit penjualan
    public function edit(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);
        $user = UserModel::all();

        $breadcrumb = (object) [
            'title' => 'Edit Penjualan',
            'list' => ['Home', 'Penjualan', 'Edit']
        ];

        $page = (object) [
            'title' => 'Edit penjualan'
        ];

        $activeMenu = 'penjualan'; // set menu yang sedang aktif

        return view('penjualan.edit', [
            'breadcrumb' => $breadcrumb,
            'page' => $page,
            'penjualan' => $penjualan,
            'user' => $user,
            'activeMenu' => $activeMenu
        ]);
    }

    // Menyimpan perubahan data penjualan
    public function update(Request $request, string $id)
    {
        $request->validate([
            'user_id' => 'required|integer',
            'penjualan_kode' => 'required|string|max:20|unique:t_penjualan,penjualan_kode,' . $id . ',penjualan_id',
            'penjualan_tanggal' => 'required|date',
        ]);

        $pembeli = UserModel::find($request->user_id)->nama;
        PenjualanModel::find($id)->update([
            'user_id' => $request->user_id,
            'pembeli' => $pembeli,
            'penjualan_kode' => $request->penjualan_kode,
            'penjualan_tanggal' => $request->penjualan_tanggal,
        ]);

        return redirect('/penjualan')->with('success', 'Data penjualan berhasil diubah');
    }

    // Menghapus data penjualan
    public function destroy(string $id)
    {
        $check = PenjualanModel::find($id); // untuk mengecek apakah data penjualan dengan id yang dimaksud ada atau tidak
        if (!$check) {
            return redirect('/penjualan')->with('error', 'Data penjualan tidak ditemukan');
        }

        try {
            PenjualanModel::destroy($id); // Hapus data penjualan
            return redirect('/penjualan')->with('success', 'Data penjualan berhasil dihapus');
        } catch (\Illuminate\Database\QueryException $e) {
            // Jika terjadi error ketika menghapus data, redirect kembali ke halaman dengan membawa pesan error
            return redirect('/penjualan')->with('error', 'Data penjualan gagal dihapus karena masih terdapat tabel lain yang terkait dengan data ini');
        }
    }
}
