<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\LevelController;
use App\Http\Controllers\KategoriController;
use App\Http\Controllers\POSController;
use App\Http\Controllers\UserController;
use App\Models\LevelModel;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/kategori', [KategoriController::class, 'index']);
Route::get('/kategori/create', [KategoriController::class, 'create']);
Route::post('/kategori', [KategoriController::class, 'store']);
Route::get('/kategori/edit/{id}', [KategoriController::class, 'edit']);
Route::post('/kategori/edit', [KategoriController::class, 'update']);
Route::get('/kategori/hapus/{id}', [KategoriController::class, 'delete']);

Route::resource('m_user', POSController::class);

Route::group(['prefix' => 'form'], function () {
    Route::get('/m_user', function () {
        $page = (object) [
            'title' => 'Daftar user yang terdaftar dalam sistem'
        ];
        $activeMenu = 'user'; // set menu yang sedang aktif 
        $level = LevelModel::all();
        return view('form.m_user', ['page' => $page, 'level' => $level, 'activeMenu' => $activeMenu]);
    });
    Route::get('/m_level', function () {
        $page = (object)[
            'title' => 'Daftar level yang terdaftar dalam sistem'
        ];
        $activeMenu = 'level';
        return view('form.m_level', ['page' => $page, 'activeMenu' => $activeMenu]);
    });
});

// JS4: Praktikum 2.6
Route::get('/level', [LevelController::class, 'index']);
Route::get('/user', [UserController::class, 'index']);
Route::get('/user/tambah', [UserController::class, 'tambah']);
Route::post('/user/tambah_simpan', [UserController::class, 'tambah_simpan']);
Route::get('/user/ubah/{id}', [UserController::class, 'ubah']);
Route::put('/user/ubah_simpan/{id}', [UserController::class, 'ubah_simpan']);
Route::get('/user/hapus/{id}', [UserController::class, 'hapus']);
