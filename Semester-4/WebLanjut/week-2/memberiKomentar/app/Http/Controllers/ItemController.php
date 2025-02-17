<?php

// Mendifinisikan namespace App\Http\Controllers
namespace App\Http\Controllers;

// Mengimpor model class Item
use App\Models\Item;
// Mengimpor class Request dari Laravel
use Illuminate\Http\Request;

class ItemController extends Controller
{
    // Menampilkan daftar semua item
    public function index()
    {
        // Mengambil semua data item dari database
        $items = Item::all();
        // Menampilkan view items.index dan mengirimkan data items
        return view('items.index', compact('items'));
    }

    // Menampilkan form untuk membuat item baru
    public function create()
    {
        // Menampilkan items.create
        return view('items.create');
    }

    // Menyimpan item baru
    public function store(Request $request)
    {
        // Validasi inputan
        $request->validate([
            'name' => 'required', // Nama harus diisi
            'description' => 'required', // Deskripsi harus diisi
        ]);

        // Hanya memasukkan atribut yang diizinkan
        Item::create($request->only(['name', 'description']));
        // Kembali ke items.index dengan pesan success Item added successfully.
        return redirect()->route('items.index')->with('success', 'Item added successfully.');
    }

    // Menampilkan detail item
    public function show(Item $item)
    {
        // Menampilkan items.show
        return view('items.show', compact('item'));
    }

    // Menampilkan form untuk mengedit item
    public function edit(Item $item)
    {
        // Menampilkan items.edit
        return view('items.edit', compact('item'));
    }

    // Memperbarui item yang ada
    public function update(Request $request, Item $item)
    {
        // Validasi inputan
        $request->validate([
            'name' => 'required', // Nama harus diisi
            'description' => 'required', // Deskripsi harus diisi
        ]);

        // Hanya masukkan atribut yang diizinkan
        $item->update($request->only(['name', 'description']));
        // Kembali ke items.index dengan pesan success Item updated successfully.
        return redirect()->route('items.index')->with('success', 'Item updated successfully.');
    }

    // Menghapus item
    public function destroy(Item $item)
    {
        // Menghapus item
        $item->delete();
        // Kembali ke items.index dengan pesan success Item deleted successfully.
        return redirect()->route('items.index')->with('success', 'Item deleted successfully.');
    }
}
