<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('t_stok', function (Blueprint $table) {
            $table->dropForeign('t_stok_user_id_foreign');
            $table->dropColumn('user_id');
            $table->unsignedBigInteger('supplier_id')->after('barang_id');
            $table->foreign('supplier_id')->references('supplier_id')->on('m_supplier');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('t_stok', function (Blueprint $table) {
            $table->dropForeign('t_stok_supplier_id_foreign');
            $table->dropColumn('supplier_id');
            $table->unsignedBigInteger('user_id')->after('barang_id');
            $table->foreign('user_id')->references('user_id')->on('m_user');            
        });
    }
};
