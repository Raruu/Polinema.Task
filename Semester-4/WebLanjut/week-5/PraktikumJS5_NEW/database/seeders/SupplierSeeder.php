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
            ['supplier_id' => 1, 'supplier_kode' => 'SUP-004', 'supplier_nama' => 'PT Sukses Selalu', 'supplier_alamat' => 'Jl. Merdeka No. 10, Yogyakarta'],
            ['supplier_id' => 2, 'supplier_kode' => 'SUP-005', 'supplier_nama' => 'CV Abadi Jaya', 'supplier_alamat' => 'Jl. Sudirman No. 20, Medan'],
            ['supplier_id' => 3, 'supplier_kode' => 'SUP-006', 'supplier_nama' => 'UD Sejahtera', 'supplier_alamat' => 'Jl. Gatot Subroto No. 30, Bali'],
        ];
        DB::table('m_supplier')->insert($data);
    }
}
