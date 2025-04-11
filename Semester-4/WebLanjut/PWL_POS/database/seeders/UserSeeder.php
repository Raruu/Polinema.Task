<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $data = [
            [
                'user_id' => 1,
                'level_id' => 1,
                'username' => 'admin',
                'nama' => 'Administrator',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 2,
                'level_id' => 1,
                'username' => 'raruu',
                'nama' => 'Raruu',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 3,
                'level_id' => 2,
                'username' => 'manager',
                'nama' => 'Manager',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 4,
                'level_id' => 3,
                'username' => 'staff',
                'nama' => 'Staff',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 5,
                'level_id' => 4,
                'username' => 'yuki',
                'nama' => 'Yuki Kaai',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 6,
                'level_id' => 4,
                'username' => 'nukunuku',
                'nama' => 'Nukunuku Nigirimeshi',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 7,
                'level_id' => 4,
                'username' => 'teto',
                'nama' => 'Teto Kasane',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 8,
                'level_id' => 4,
                'username' => 'ikuyo',
                'nama' => 'Kita Ikuyo',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 9,
                'level_id' => 4,
                'username' => 'osage',
                'nama' => 'Osage chan',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'user_id' => 10,
                'level_id' => 4,
                'username' => 'miku',
                'nama' => 'Miku Hatsune',
                'password' => Hash::make('12345'),
                'created_at' => now(),
                'updated_at' => now(),
            ]
        ];
        DB::table('m_user')->insert($data);
    }
}
