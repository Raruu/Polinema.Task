<?php

namespace App\Http\Controllers;

use App\Models\PenjualanDetailModel;
use App\Models\PenjualanModel;
use Carbon\Carbon;
use Illuminate\Support\Facades\Auth;

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
            $penjualanTrend[$key]['jumlah'] = 0;
            foreach ($value as $value2) {
                if (isset($value2->penjualan_id) && ($jumlah = PenjualanDetailModel::where('penjualan_id', $value2->penjualan_id)
                    ->sum('jumlah')) > 0) {
                    $penjualanTrend[$key]['jumlah'] += $jumlah;
                    $penjualanIds[] = $value2->penjualan_id;
                }
            }

            unset($value[0]);
        }
        unset($value);

        $penjualanRanking = [];
        foreach ($penjualanIds as $value) {
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
            $found = false;
            foreach ($carry as &$existing) {
                if ($existing->barang_id === $item->barang_id) {
                    $existing->jumlah += $item->jumlah;
                    $found = true;
                    break;
                }
            }
            unset($existing);
            if (!$found) {
                $carry[] = $item;
            }
            return $carry;
        }, []);

        usort($penjualanRanking, function ($a, $b) {
            return $b->jumlah <=> $a->jumlah;
        });
        $penjualanRanking = array_slice($penjualanRanking, 0, 5);

        $user = Auth::user();

        return view('welcome', [
            'breadcrumb' => $breadcrumb,
            'activeMenu' => $activeMenu,
            'penjualanTrend' => $penjualanTrend,
            'penjualanRanking' => $penjualanRanking,
            'user' => $user,
        ]);
    }
}
