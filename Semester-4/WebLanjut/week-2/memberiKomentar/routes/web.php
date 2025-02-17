<?php

// Mengimport dari laravel
use Illuminate\Support\Facades\Route;
// Mengimport ItemController
use App\Http\Controllers\ItemController;

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

// Route awal ('/')
Route::get('/', function () {
    return view('welcome');
});

// Mendefinisikan route dari ItemController menggunakan Route::resource()
Route::resource('items', ItemController::class);
