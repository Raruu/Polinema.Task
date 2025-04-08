<?php

namespace App\Http\Controllers;

use App\DataTables\PenjualanDataTable;
use App\Models\BarangModel;
use App\Models\PenjualanDetailModel;
use App\Models\PenjualanModel;
use App\Models\StokModel;
use App\Models\UserModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

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

    public function list(PenjualanDataTable $dataTable)
    {
        return $dataTable->render();
    }

    public function create()
    {
        $breadcrumb = (object) [
            'title' => 'Tambah Penjualan',
            'list' => ['Home', 'Penjualan', 'Tambah']
        ];

        $page = (object) [
            'title' => 'Tambah penjualan baru'
        ];

        $activeMenu = 'penjualan';
        $user = UserModel::all();
        $barang = BarangModel::all();

        return view('penjualan.create', [
            'breadcrumb' => $breadcrumb,
            'page' => $page,
            'user' => $user,
            'barang' => $barang,
            'activeMenu' => $activeMenu
        ]);
    }

    public function create_ajax()
    {
        $user = UserModel::all();
        $barang = BarangModel::all();

        return view('penjualan.create_ajax', [
            'user' => $user,
            'barang' => $barang
        ]);
    }

    public function store(Request $request)
    {
        $request->validate([
            'user_id' => 'required|integer',
            'penjualan_kode' => 'required|string|max:20|unique:t_penjualan,penjualan_kode',
            'penjualan_tanggal' => 'required|date',
            'barang_nama' => 'required|array',
            'barang_nama.*' => 'required|string|max:50',
            'jumlah' => 'required|array',
            'jumlah.*' => 'required|integer|min:1',
        ]);

        $pembeli = UserModel::find($request->user_id)->nama;
        $penjualan = PenjualanModel::create([
            'user_id' => $request->user_id,
            'pembeli' => $pembeli,
            'penjualan_kode' => $request->penjualan_kode,
            'penjualan_tanggal' => $request->penjualan_tanggal,
        ]);

        foreach ($request->barang_nama as $key => $barang_nama) {
            $barang_id = BarangModel::where('barang_nama', $barang_nama)->first()->barang_id;
            $harga = BarangModel::where('barang_id', $barang_id)->first()->harga_jual;

            $stok = StokModel::where('barang_id', $barang_id)->first();
            if (!empty($stok) && $request->kurangi_stok) {
                $stok->update([
                    'stok_jumlah' => $stok->stok_jumlah - $request->jumlah[$key]
                ]);
            }

            PenjualanDetailModel::create([
                'penjualan_id' => $penjualan->penjualan_id,
                'barang_id' => $barang_id,
                'jumlah' => $request->jumlah[$key],
                'harga' => $harga
            ]);
        }

        return redirect('/penjualan')->with('success', 'Data penjualan berhasil disimpan');
    }

    public function store_ajax(Request $request)
    {
        if ($request->ajax() || $request->wantsJson()) {
            $rules = [
                'user_id' => 'required|integer',
                'penjualan_kode' => 'required|string|max:20|unique:t_penjualan,penjualan_kode',
                'penjualan_tanggal' => 'required|date',
                'barang_nama' => 'required|array',
                'barang_nama.*' => 'required|string|max:50',
                'jumlah' => 'required|array',
                'jumlah.*' => 'required|integer|min:1',
            ];

            $validator = Validator::make($request->all(), $rules);

            if ($validator->fails()) {
                return response()->json([
                    'status' => false,
                    'message' => 'Validasi Gagal',
                    'msgField' => $validator->errors()
                ]);
            }

            try {
                $pembeli = UserModel::find($request->user_id)->nama;
                $penjualan = PenjualanModel::create([
                    'user_id' => $request->user_id,
                    'pembeli' => $pembeli,
                    'penjualan_kode' => $request->penjualan_kode,
                    'penjualan_tanggal' => $request->penjualan_tanggal,
                ]);

                foreach ($request->barang_nama as $key => $barang_nama) {
                    $barang_id = BarangModel::where('barang_nama', $barang_nama)->first()->barang_id;
                    $harga = BarangModel::where('barang_id', $barang_id)->first()->harga_jual;

                    $stok = StokModel::where('barang_id', $barang_id)->first();
                    if (!empty($stok) && $request->kurangi_stok) {
                        $stok->update([
                            'stok_jumlah' => $stok->stok_jumlah - $request->jumlah[$key]
                        ]);
                    }

                    PenjualanDetailModel::create([
                        'penjualan_id' => $penjualan->penjualan_id,
                        'barang_id' => $barang_id,
                        'jumlah' => $request->jumlah[$key],
                        'harga' => $harga
                    ]);
                }
                return response()->json([
                    'status' => true,
                    'message' => 'Data penjualan berhasil disimpan'
                ]);
            } catch (\Illuminate\Database\QueryException $e) {
                return response()->json([
                    'status' => false,
                    'message' => 'Data penjualan gagal disimpan'
                ]);
            }
        }
    }

    public function show(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);
        $detail = PenjualanDetailModel::with('barang')->where('penjualan_id', $id)->get();

        $breadcrumb = (object) [
            'title' => 'Detail penjualan',
            'list' => ['Home', 'Penjualan', 'Detail']
        ];

        $page = (object) [
            'title' => 'Detail penjualan'
        ];

        $activeMenu = 'penjualan';

        return view('penjualan.show', [
            'breadcrumb' => $breadcrumb,
            'page' => $page,
            'penjualan' => $penjualan,
            'detail' => $detail,
            'activeMenu' => $activeMenu
        ]);
    }

    public function show_ajax(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);
        $detail = PenjualanDetailModel::with('barang')->where('penjualan_id', $id)->get();

        return view('penjualan.show_ajax', [
            'penjualan' => $penjualan,
            'detail' => $detail,
        ]);
    }

    public function edit(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);
        $penjualanDetail = PenjualanDetailModel::with('barang')->where('penjualan_id', $id)->get();
        $user = UserModel::all();
        $barang = BarangModel::all();

        $breadcrumb = (object) [
            'title' => 'Edit Penjualan',
            'list' => ['Home', 'Penjualan', 'Edit']
        ];

        $page = (object) [
            'title' => 'Edit penjualan'
        ];

        $activeMenu = 'penjualan';

        return view('penjualan.edit', [
            'breadcrumb' => $breadcrumb,
            'page' => $page,
            'penjualan' => $penjualan,
            'penjualanDetail' => $penjualanDetail,
            'barang' => $barang,
            'user' => $user,
            'activeMenu' => $activeMenu
        ]);
    }

    public function edit_ajax(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);
        $penjualanDetail = PenjualanDetailModel::with('barang')->where('penjualan_id', $id)->get();
        $user = UserModel::all();
        $barang = BarangModel::all();

        return view('penjualan.edit_ajax', [
            'penjualan' => $penjualan,
            'penjualanDetail' => $penjualanDetail,
            'barang' => $barang,
            'user' => $user
        ]);
    }

    public function update(Request $request, string $id)
    {
        $request->validate([
            'user_id' => 'required|integer',
            'penjualan_kode' => 'required|string|max:20|unique:t_penjualan,penjualan_kode,' . $id . ',penjualan_id',
            'penjualan_tanggal' => 'required|date',
            'barang_nama' => 'required|array',
            'barang_nama.*' => 'required|string|max:50',
            'jumlah' => 'required|array',
            'jumlah.*' => 'required|integer|min:1',
        ]);

        $pembeli = UserModel::find($request->user_id)->nama;
        $penjualan = PenjualanModel::find($id);
        $penjualan->update([
            'user_id' => $request->user_id,
            'pembeli' => $pembeli,
            'penjualan_kode' => $request->penjualan_kode,
            'penjualan_tanggal' => $request->penjualan_tanggal,
        ]);

        $penjualanDetail = PenjualanDetailModel::where('penjualan_id', $id)->get();
        $barangIdArray = [];
        foreach ($request->barang_nama as $key => $barang_nama) {
            $barang_id = BarangModel::where('barang_nama', $barang_nama)->first()->barang_id;
            $harga = BarangModel::where('barang_id', $barang_id)->first()->harga_jual;
            $barangIdArray[] = $barang_id;
            $check = $penjualanDetail->where('barang_id', $barang_id)->first();
            if ($check) {
                $check->update([
                    'penjualan_id' => $penjualan->penjualan_id,
                    'barang_id' => $barang_id,
                    'jumlah' => $request->jumlah[$key],
                    'harga' => $harga
                ]);
            } else {
                PenjualanDetailModel::create([
                    'penjualan_id' => $penjualan->penjualan_id,
                    'barang_id' => $barang_id,
                    'jumlah' => $request->jumlah[$key],
                    'harga' => $harga
                ]);
            }
        }

        foreach ($penjualanDetail as $detail) {
            if (!in_array($detail->barang_id, $barangIdArray)) {
                $detail->delete();
            }
        }

        return redirect('/penjualan')->with('success', 'Data penjualan berhasil diubah');
    }

    public function update_ajax(Request $request, string $id)
    {
        $rules = [
            'user_id' => 'required|integer',
            'penjualan_kode' => 'required|string|max:20|unique:t_penjualan,penjualan_kode,' . $id . ',penjualan_id',
            'penjualan_tanggal' => 'required|date',
            'barang_nama' => 'required|array',
            'barang_nama.*' => 'required|string|max:50',
            'jumlah' => 'required|array',
            'jumlah.*' => 'required|integer|min:1',
        ];

        $validator = Validator::make($request->all(), $rules);
        if ($validator->fails()) {
            return response()->json([
                'status' => false,
                'message' => 'Validasi gagal.',
                'msgField' => $validator->errors()
            ]);
        }

        try {
            $pembeli = UserModel::find($request->user_id)->nama;
            $penjualan = PenjualanModel::find($id);
            $penjualan->update([
                'user_id' => $request->user_id,
                'pembeli' => $pembeli,
                'penjualan_kode' => $request->penjualan_kode,
                'penjualan_tanggal' => $request->penjualan_tanggal,
            ]);

            $penjualanDetail = PenjualanDetailModel::where('penjualan_id', $id)->get();
            $barangIdArray = [];
            foreach ($request->barang_nama as $key => $barang_nama) {
                $barang_id = BarangModel::where('barang_nama', $barang_nama)->first()->barang_id;
                $harga = BarangModel::where('barang_id', $barang_id)->first()->harga_jual;
                $barangIdArray[] = $barang_id;
                $check = $penjualanDetail->where('barang_id', $barang_id)->first();
                if ($check) {
                    $check->update([
                        'penjualan_id' => $penjualan->penjualan_id,
                        'barang_id' => $barang_id,
                        'jumlah' => $request->jumlah[$key],
                        'harga' => $harga
                    ]);
                } else {
                    PenjualanDetailModel::create([
                        'penjualan_id' => $penjualan->penjualan_id,
                        'barang_id' => $barang_id,
                        'jumlah' => $request->jumlah[$key],
                        'harga' => $harga
                    ]);
                }
            }

            foreach ($penjualanDetail as $detail) {
                if (!in_array($detail->barang_id, $barangIdArray)) {
                    $detail->delete();
                }
            }

            return response()->json([
                'status' => true,
                'message' => 'Data penjualan berhasil diubah'
            ]);
        } catch (\Illuminate\Database\QueryException $e) {
            return response()->json([
                'status' => false,
                'message' => 'Data penjualan gagal diubah'
            ]);
        }
    }

    public function destroy(string $id)
    {
        $checkPenjualan = PenjualanModel::find($id);

        if (!$checkPenjualan) {
            return redirect('/penjualan')->with('error', 'Data penjualan tidak ditemukan');
        }

        try {
            PenjualanDetailModel::where('penjualan_id', $id)->delete();
            PenjualanModel::destroy($id);
            return redirect('/penjualan')->with('success', 'Data penjualan berhasil dihapus');
        } catch (\Illuminate\Database\QueryException $e) {
            return redirect('/penjualan')->with('error', 'Data penjualan gagal dihapus karena masih terdapat tabel lain yang terkait dengan data ini');
        }
    }

    public function confirm_ajax(string $id)
    {
        $penjualan = PenjualanModel::with('user')->find($id);
        $detail = PenjualanDetailModel::with('barang')->where('penjualan_id', $id)->get();

        return view('penjualan.confirm_ajax', [
            'penjualan' => $penjualan,
            'detail' => $detail,
        ]);
    }

    public function delete_ajax(Request $request, $id)
    {
        if ($request->ajax() || $request->wantsJson()) {
            $penjualan = PenjualanModel::find($id);

            if ($penjualan) {
                try {
                    PenjualanDetailModel::where('penjualan_id', $id)->delete();
                    $penjualan->delete();
                    return response()->json([
                        'status' => true,
                        'message' => 'Data berhasil dihapus'
                    ]);
                } catch (\Illuminate\Database\QueryException $e) {
                    return response()->json([
                        'status' => false,
                        'message' => 'Data tidak bisa dihapus'
                    ]);
                }
            } else {
                return response()->json([
                    'status' => false,
                    'message' => 'Data tidak ditemukan'
                ]);
            }
        }
        return redirect('/');
    }
}
