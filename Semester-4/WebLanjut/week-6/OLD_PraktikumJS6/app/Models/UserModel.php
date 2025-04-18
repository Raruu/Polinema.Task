<?php

namespace App\Models;

// use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

class UserModel extends Model
{
    // use HasFactory;

    protected $table = 'm_user';
    public $timestamps = false;
    protected $primaryKey = 'user_id';

    protected $fillable = ['user_id', 'level_id', 'username', 'nama', 'password'];

    public function level(): BelongsTo
    {
        // JS4: Praktikum 2.7
        return $this->belongsTo(LevelModel::class, 'level_id', 'level_id');
    }
}
