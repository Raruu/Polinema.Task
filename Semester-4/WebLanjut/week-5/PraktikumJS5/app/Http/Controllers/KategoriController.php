<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\DataTables\KategoriDataTable;
use App\Models\KategoriModel;

class KategoriController extends Controller
{
    public function index(KategoriDataTable $dataTable)
    {
        return $dataTable->render('kategori.index');
    }

    public function create()
    {
        return view('kategori.create');
    }

    public function store(Request $request)
    {
        KategoriModel::create([
            'kategori_kode' => $request->kodeKategori,
            'kategori_nama' => $request->namaKategori,
        ]);
        return redirect('/kategori');
    }    

    public function edit($id)
    {
        $row = KategoriModel::findOrFail($id);
        return view('kategori.edit', ['data' => $row]);
    }

    public function update(Request $request, $id)
    {
        $row = KategoriModel::findOrFail($id);
        $row->kategori_kode = $request->kodeKategori;
        $row->kategori_nama = $request->namaKategori;
        $row->save();
        return redirect('/kategori');
    }

    
    public function delete($id)
    {
        $row = KategoriModel::findOrFail($id);
        $row->delete();
        return redirect('/kategori');
    }
}
