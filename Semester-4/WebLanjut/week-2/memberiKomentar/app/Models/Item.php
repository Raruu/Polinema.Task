<?php

// Mendifinisikan namespace App\Models
namespace App\Models;

// Mengimport dari laravel
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Item extends Model
{
    use HasFactory;
    // Menandai atribut yang dapat diisi
    protected $fillable = [
        'name',
        'description',
    ];
}
