<?php

namespace App\Http\Controllers;

use App\Models\UserModel;
use Illuminate\Support\Facades\Hash;
use Illuminate\Http\Request;

class UserController extends Controller
{
    public function index()
    {
        // JS3
        // $data = [
        //     'username' => 'customer-1',
        //     'nama' => 'Pelanggan',
        //     'password' => Hash::make('12345'),
        //     'level_id' => 4
        // ];
        // UserModel::insert($data);

        // $data = ['nama' => 'Pelanggan Pertama'];
        // UserModel::where('username', 'customer-1')->update($data);
        // END JS3

        // JS4: Praktikum 1
        // $data = [
        //     'level_id' => 2,
        //     // 'username' => 'manager_dua',
        //     // 'nama' => 'Manager 2',
        //     'username' => 'manager_tiga',
        //     'nama' => 'Manager 3',
        //     'password' => Hash::make('12345')
        // ];
        // UserModel::create($data);

        // $user = UserModel::all();

        // JS4: Praktikum 2.1
        // $user = UserModel::find(1);
        // $user = UserModel::where('level_id', 1)->first();
        // $user = UserModel::firstWhere('level_id', 1);
        // $user = UserModel::findOr(20, ['username', 'nama'], function () {
        //     abort(404);
        // });

        // JS4: Praktikum 2.2
        // $user = UserModel::findOrFail(1);
        // $user = UserModel::where('username', 'manager9')->firstOrFail();

        // JS4: Praktimum 2.3
        // $user = UserModel::where('level_id', 2)->count();
        // dd($user);

        // JS4: Praktimum 2.4
        // $user = UserModel::firstOrCreate(
        //     [
        //         'username' => 'manager22',
        //         'nama' => 'Manager Dua Dua',
        //         'password' => Hash::make('12345'),
        //         'level_id' => 2
        //     ],
        // );
        // $user = UserModel::firstOrNew(
        //     [
        //         'username' => 'manager33',
        //         'nama' => 'Manager Tiga Tiga',
        //         'password' => Hash::make('12345'),
        //         'level_id' => 2
        //     ],
        // );
        // $user->save();

        // JS4: Praktimum 2.5
        // $user = UserModel::create([
        //     'username' => 'manager55',
        //     'nama' => 'Manager55',
        //     'password' => Hash::make('12345'),
        //     'level_id' => 2,
        // ]);
        // $user->username = 'manager56';

        // $user->isDirty(); // true 
        // $user->isDirty('username'); // true 
        // $user->isDirty('nama'); // false 
        // $user->isDirty(['nama', 'username']); // true 

        // $user->isClean(); // false 
        // $user->isClean('username'); // false 
        // $user->isClean('nama'); // true 
        // $user->isClean(['nama', 'username']); // false 

        // $user->save();

        // $user->isDirty(); // false 
        // $user->isClean(); // true
        // dd($user->isDirty());

        $user = UserModel::create([
            'username' => 'manager11',
            'nama' => 'Manager11',
            'password' => Hash::make('12345'),
            'level_id' => 2,
        ]);
        $user->username = 'manager12';

        $user->save();
        
        $user->wasChanged(); // true 
        $user->wasChanged('username'); // true 
        $user->wasChanged(['username', 'level_id']); // true 
        $user->wasChanged('nama'); // false 
        dd($user->wasChanged(['nama', 'username'])); // true
        return view('user', ['data' => $user]);
    }
}
