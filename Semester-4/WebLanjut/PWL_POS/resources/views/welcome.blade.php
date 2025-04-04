@extends('layouts.template')
@section('content')
    <div>
        <div class="d-flex flex-row" style="gap: 10px; max-width: 99%">
            <div class="card col-md-6">
                <div class="card-header border-0">
                    <div class="d-flex justify-content-between">
                        <h3 class="card-title">Penjualan 7 hari terakhir</h3>
                    </div>
                </div>
                <div class="card-body">
                    <div class="d-flex">
                        <p class="d-flex flex-column">
                            <span class="text-bold text-lg">
                                {{ array_sum($penjualanTrend->map(fn($item) => $item['jumlah'])->toArray()) }}
                            </span>
                            <span>Produk terjual</span>
                        </p>
                    </div>

                    <div class="position-relative mb-4">
                        <div class="chartjs-size-monitor">
                            <div class="chartjs-size-monitor-expand">
                                <div class=""></div>
                            </div>
                            <div class="chartjs-size-monitor-shrink">
                                <div class=""></div>
                            </div>
                        </div>
                        <canvas id="visitors-chart" height="200" width="530"
                            style="display: block; width: 530px; height: 200px;" class="chartjs-render-monitor"></canvas>
                    </div>
                </div>
            </div>
            <!-- /.card -->

            <div class="card col-md-6">
                <div class="card-header border-0">
                    <h3 class="card-title">TOP 5 Produk terbeli paling banyak</h3>
                </div>
                <div class="card-body table-responsive p-0">
                    <table class="table table-striped table-hover table-valign-middle">
                        <thead>
                            <tr>
                                <th>Nama Barang</th>
                                <th>Harga Beli</th>
                                <th>Harga Jual</th>
                                <th>Jumlah</th>
                            </tr>
                        </thead>
                        <tbody>
                            @foreach ($penjualanRanking as $item)
                                <tr style="cursor: pointer" onclick="window.location.href = '{{ url('barang/' . $item->barang_id) }}'">
                                    <td>{{ $item->barang_nama }}</td>
                                    <td>Rp. {{ number_format($item->harga_beli, 0, ',', '.') }}</td>
                                    <td>Rp. {{ number_format($item->harga_jual, 0, ',', '.') }}</td>
                                    <td>{{ $item->jumlah }}</td>
                                </tr>
                            @endforeach
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- /.card -->
        </div>
    </div>
@endsection

@push('js')
    <script src="{{ asset('adminlte/plugins/chart.js/Chart.min.js') }}"></script>
    <script>
        $(function() {
            'use strict'
            const ticksStyle = {
                fontColor: '#495057',
                fontStyle: 'bold'
            }
            const mode = 'index';
            const intersect = false;
            const $visitorsChart = $('#visitors-chart')
            // eslint-disable-next-line no-unused-vars

            const penjualanTrend = <?php echo json_encode($penjualanTrend); ?>;
            const penjualanTrendValues = Object.values(penjualanTrend).map(item => item.jumlah)
            var visitorsChart = new Chart($visitorsChart, {
                data: {
                    labels: Object.keys(penjualanTrend),
                    datasets: [{
                        type: 'line',
                        data: penjualanTrendValues,
                        backgroundColor: 'transparent',
                        borderColor: '#007bff',
                        pointBorderColor: '#007bff',
                        pointBackgroundColor: '#007bff',
                        fill: false
                    }, ]
                },
                options: {
                    maintainAspectRatio: false,
                    tooltips: {
                        mode: mode,
                        intersect: intersect
                    },
                    hover: {
                        mode: mode,
                        intersect: intersect
                    },
                    legend: {
                        display: false
                    },
                    scales: {
                        yAxes: [{
                            // display: false,
                            gridLines: {
                                display: true,
                                lineWidth: '4px',
                                color: 'rgba(0, 0, 0, .2)',
                                zeroLineColor: 'transparent'
                            },
                            ticks: $.extend({
                                beginAtZero: true,
                                suggestedMax: Math.max(...penjualanTrendValues),
                            }, ticksStyle)
                        }],
                        xAxes: [{
                            display: true,
                            gridLines: {
                                display: false
                            },
                            ticks: ticksStyle
                        }]
                    }
                }
            })
        })
    </script>
@endpush
