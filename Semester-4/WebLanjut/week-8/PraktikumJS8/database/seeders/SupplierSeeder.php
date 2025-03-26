<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class SupplierSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $data = [
            [
                'supplier_id' => 1,
                'supplier_kode' => 'SUP-001',
                'supplier_nama' => 'PT Sukses Selalu',
                'supplier_alamat' => 'Jl. Merdeka No. 10, Yogyakarta',
                'supplier_telepon' => '0274-12345678',
                'supplier_email' => 'sukses.selalu@supplier.com',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'supplier_id' => 2,
                'supplier_kode' => 'SUP-002',
                'supplier_nama' => 'CV Abadi Jaya',
                'supplier_alamat' => 'Jl. Sudirman No. 20, Medan',
                'supplier_telepon' => '061-12345678',
                'supplier_email' => 'abadi.jaya@supplier.com',
                'created_at' => now(),
                'updated_at' => now(),
            ],
            [
                'supplier_id' => 3,
                'supplier_kode' => 'SUP-003',
                'supplier_nama' => 'UD Sejahtera',
                'supplier_alamat' => 'Jl. Gatot Subroto No. 30, Bali',
                'supplier_telepon' => '0361-12345678',
                'supplier_email' => 'sejahtera@supplier.com',
                'created_at' => now(),
                'updated_at' => now(),
            ],
        ];
        DB::table('m_supplier')->insert($data);
    }
}
