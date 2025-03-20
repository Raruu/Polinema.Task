<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\DataTables\KategoriDataTable;
use App\Http\Requests\StorePostRequest;
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

    public function store(StorePostRequest $request)
    {
        // The incoming request is valid... 
        // Retrieve the validated input data... 
        $validated = $request->validated();
        // Retrieve a portion of the validated input data... 
        $validated = $request->safe()->only(['kategori_kode', 'kategori_nama']);
        $validated = $request->safe()->except(['kategori_kode', 'kategori_nama']);
        // Store the post...
        return redirect('/kategori');
    }

    public function edit($id)
    {
        $row = KategoriModel::findOrFail($id);
        return view('kategori.edit', ['data' => $row]);
    }

    public function update(Request $request)
    {
        $row = KategoriModel::findOrFail($request->kategori_id);
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
