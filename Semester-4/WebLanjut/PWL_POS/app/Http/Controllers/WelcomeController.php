<?php

namespace App\Http\Controllers;

use App\Models\PenjualanDetailModel;
use App\Models\PenjualanModel;
use Carbon\Carbon;

class WelcomeController extends Controller
{
    public function index()
    {
        $breadcrumb = (object) [
            'title' => 'Dashboard',
            'list' => ['Home', 'Dashboard']
        ];
        $activeMenu = 'dashboard';

        $latestDate = PenjualanModel::max('penjualan_tanggal');
        $penjualanTrend = PenjualanModel::select('penjualan_id', 'penjualan_tanggal')
            ->where('penjualan_tanggal', '>=', Carbon::parse($latestDate)->subDays(7))
            ->orderBy('penjualan_tanggal', 'asc')
            ->get()
            ->groupBy(function ($item) {
                return Carbon::parse($item->penjualan_tanggal)->format('Y-m-d');
            });

        $penjualanIds = [];
        foreach ($penjualanTrend as $key => &$value) {
            $tempData = [];
            foreach ($value as $key2 => $value2) {
                if (($jumlah = PenjualanDetailModel::where('penjualan_id', $value2->penjualan_id)
                    ->sum('jumlah')) > 0) {
                    $tempData[$value2->penjualan_id] = $jumlah;
                    $penjualanIds[] = $value2->penjualan_id;
                }
                unset($value[$key2]);
            }
            $penjualanTrend[$key]['jumlah'] = 0;
            foreach ($tempData as $value2) {
                $penjualanTrend[$key]['jumlah'] += $value2;
            }
        }
        unset($value);
        
        foreach ($penjualanIds as &$value) {
            $temp = PenjualanDetailModel::with('barang')
                ->where('penjualan_id', $value)
                ->orderByDesc('jumlah')
                ->get()
                ->map(function ($item) {
                    return (object) [
                        'barang_id' => $item->barang_id,
                        'barang_nama' => $item->barang->barang_nama,
                        'harga_beli' => $item->barang->harga_beli,
                        'harga_jual' => $item->barang->harga_jual,
                        'jumlah' => $item->jumlah
                    ];
                })->toArray();

            $temp = collect($temp)->sortByDesc('jumlah')->first();
            $penjualanRanking[] = (object) [
                'penjualan_id' => $value,
                'barang_id' => $temp->barang_id,
                'barang_nama' => $temp->barang_nama,
                'harga_beli' => $temp->harga_beli,
                'harga_jual' => $temp->harga_jual,
                'jumlah' => $temp->jumlah
            ];
        }

        $penjualanRanking = array_reduce($penjualanRanking, function ($carry, $item) {
            if (!array_reduce($carry, function ($innerCarry, $innerItem) use ($item) {
                return $innerCarry || $innerItem->barang_id === $item->barang_id;
            }, false)) {
                $carry[] = $item;
            } else {
                foreach ($carry as &$value) {
                    if ($value->barang_id === $item->barang_id && $item->jumlah > $value->jumlah) {
                        $value = $item;
                    }
                }
                unset($value);
            }
            return $carry;
        }, []);

        usort($penjualanRanking, function ($a, $b) {
            return $b->jumlah <=> $a->jumlah;
        });
        $penjualanRanking = array_slice($penjualanRanking, 0, 5);

        return view('welcome', [
            'breadcrumb' => $breadcrumb,
            'activeMenu' => $activeMenu,
            'penjualanTrend' => $penjualanTrend,
            'penjualanRanking' => $penjualanRanking,
        ]);
    }
}

