<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class PenjualanDetailSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $penjualans = DB::table('t_penjualan')->get();
        $barangs = DB::table('m_barang')->get();

        foreach ($penjualans as $penjualan) {
            $selectedBarangs = [];
            for ($i = 0; $i < 3; $i++) {
                do {
                    $barangRand = rand(0, $barangs->count() - 1);
                } while (in_array($barangRand, $selectedBarangs));
                
                $selectedBarangs[] = $barangRand;
                $barang = $barangs[$barangRand];
                DB::table('t_penjualan_detail')->insert([
                    'penjualan_id' => $penjualan->penjualan_id,
                    'barang_id' => $barang->barang_id,
                    'harga' => $barang->harga_jual,
                    'jumlah' => rand(1, 15),
                    'created_at' => now(),
                    'updated_at' => now(),
                ]);
            }
        }
    }
}
