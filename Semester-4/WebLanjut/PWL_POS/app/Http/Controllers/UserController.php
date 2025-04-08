<?php

namespace App\Http\Controllers;

use App\DataTables\UserDataTable;
use App\Models\LevelModel;
use App\Models\UserModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use PhpOffice\PhpSpreadsheet\IOFactory;
use PhpOffice\PhpSpreadsheet\Spreadsheet;

class UserController extends Controller
{
    public function index()
    {
        $breadcrumb = (object) [
            'title' => 'Daftar User',
            'list' => ['Home', 'User']
        ];
        $page = (object) [
            'title' => 'Daftar user yang terdaftar dalam sistem'
        ];
        $activeMenu = 'user';
        $level = LevelModel::all();
        return view('user.index', ['breadcrumb' => $breadcrumb, 'page' => $page, 'level' => $level, 'activeMenu' => $activeMenu]);
    }

    public function list(UserDataTable $dataTable)
    {
        return $dataTable->render();
    }

    public function create()
    {
        $breadcrumb = (object) [
            'title' => 'Tambah User',
            'list' => ['Home', 'User', 'Tambah']
        ];
        $page = (object) [
            'title' => 'Tambah user baru'
        ];
        $level = LevelModel::all();
        $activeMenu = 'user';
        return view('user.create', ['breadcrumb' => $breadcrumb, 'page' => $page, 'level' => $level, 'activeMenu' => $activeMenu]);
    }

    public function create_ajax()
    {
        $level = LevelModel::select('level_id', 'level_nama')->get();

        return view('user.create_ajax')
            ->with('level', $level);
    }

    public function store(Request $request)
    {
        $request->validate([
            'username' => 'required|string|min:3|unique:m_user,username',
            'nama' => 'required|string|max: 100',
            'password' => 'required|min:5',
            'level_id' => 'required|integer'
        ]);

        UserModel::create([
            'username' => $request->username,
            'nama' => $request->nama,
            'password' => bcrypt($request->password),
            'level_id' => $request->level_id
        ]);
        return redirect('/user')->with('success', 'Data user berhasil disimpan');
    }

    public function store_ajax(Request $request)
    {
        if ($request->ajax() || $request->wantsJson()) {
            $rules = [
                'level_id' => ['required', 'integer'],
                'username' => [
                    'required',
                    'max:20',
                    'unique:m_user,username',
                ],
                'nama' => ['required', 'max:100'],
                'email' => ['nullable', 'email'],
                'no_telepon' => ['nullable', 'numeric'],
                'profile_picture' => ['nullable', 'image', 'max:2048'],
                'password' => ['required', 'min:5', 'max:20']
            ];

            $validator = Validator::make($request->all(), $rules);

            if ($validator->fails()) {
                return response()->json([
                    'status' => false,
                    'message' => 'Validasi Gagal',
                    'msgField' => $validator->errors()
                ]);
            }

            $data = $request->all();
            if ($request->hasFile('profile_picture')) {
                $id = UserModel::all()->max('user_id') + 1;
                $image = $request->file('profile_picture');
                $imageName = 'profile-' . $id . '.webp';
                $image->storeAs('public/profile_pictures', $imageName);
                $data['picture_path'] = 'storage/profile_pictures/' . $imageName;
                unset($data['profile_picture']);
            }

            UserModel::create($data);

            return response()->json([
                'status' => true,
                'message' => 'Data user berhasil disimpan'
            ]);
        }
        return redirect('/');
    }

    public function show(string $id)
    {
        $user = UserModel::with('level')->find($id);
        $breadcrumb = (object) [
            'title' => 'Detail User',
            'list' => ['Home', 'User', 'Detail']
        ];
        $page = (object) [
            'title' => 'Detail user'
        ];
        $activeMenu = 'user';
        return view('user.show', ['breadcrumb' => $breadcrumb, 'page' => $page, 'user' => $user, 'activeMenu' => $activeMenu]);
    }

    public function show_ajax(string $id)
    {
        $user = UserModel::with('level')->find($id);

        return view('user.show_ajax', ['user' => $user]);
    }

    public function edit(string $id)
    {
        $user =  UserModel::find($id);
        $level = LevelModel::all();
        $breadcrumb = (object) [
            'title' => 'Edit User',
            'list' => ['Home', 'User', 'Edit']
        ];
        $page = (object) [
            'title' => 'Edit user'
        ];
        $activeMenu = 'user';
        return view('user.edit', ['breadcrumb' => $breadcrumb, 'page' => $page, 'user' => $user, 'level' => $level, 'activeMenu' => $activeMenu]);
    }

    public function edit_ajax(string $id)
    {
        $user = UserModel::find($id);
        $level = LevelModel::select('level_id', 'level_nama')->get();

        return view('user.edit_ajax', ['user' => $user, 'level' => $level]);
    }

    public function update(Request $request, string $id)
    {
        $request->validate([
            'username' => 'required|string|min:3|unique:m_user,username,' . $id . ',user_id',
            'nama' => 'required|string|max: 100',
            'password' => 'nullable|min:5',
            'level_id' => 'required|integer'
        ]);
        UserModel::find($id)->update([
            'username' => $request->username,
            'nama' => $request->nama,
            'password' => $request->password ? bcrypt($request->password) : UserModel::find($id)->password,
            'level_id' => $request->level_id
        ]);
        return redirect('/user')->with('success', 'Data user berhasil diubah');
    }

    public function update_ajax(Request $request, $id)
    {
        if ($request->ajax() || $request->wantsJson()) {
            $rules = [
                'level_id' => ['required', 'integer'],
                'username' => [
                    'required',
                    'max:20',
                    'unique:m_user,username,' . $id . ',user_id'
                ],
                'nama' => ['required', 'max:100'],
                'email' => ['nullable', 'email'],
                'no_telepon' => ['nullable', 'numeric'],
                'profile_picture' => ['nullable', 'image', 'max:2048'],
                'password' => ['nullable', 'min:5', 'max:20']
            ];

            $validator = Validator::make($request->all(), $rules);

            if ($validator->fails()) {
                return response()->json([
                    'status' => false,
                    'message' => 'Validasi gagal.',
                    'msgField' => $validator->errors()
                ]);
            }

            $check = UserModel::find($id);
            if ($check) {
                if (!$request->filled('password')) {
                    $request->request->remove('password');
                }

                $data = $request->all();
                if ($request->hasFile('profile_picture')) {
                    $image = $request->file('profile_picture');
                    $imageName = 'profile-' . $id . '.webp';
                    $image->storeAs('public/profile_pictures', $imageName);
                    $data['picture_path'] = 'storage/profile_pictures/' . $imageName;
                    unset($data['profile_picture']);
                }

                $check->update($data);
                return response()->json([
                    'status' => true,
                    'message' => 'Data berhasil diupdate'
                ]);
            } else {
                return response()->json([
                    'status' => false,
                    'message' => 'Data tidak ditemukan'
                ]);
            }
        }
        return redirect('/');
    }

    public function destroy(string $id)
    {
        $check = UserModel::find($id);
        if (!$check) {
            return redirect('/user')->with('error', 'Data user tidak ditemukan');
        }
        try {
            UserModel::destroy($id);
            return redirect('/user')->with('success', 'Data user berhasil dihapus');
        } catch (\Illuminate\Database\QueryException $e) {
            return redirect('/user')->with('error', 'Data user gagal dihapus karena masih terdapat tabel lain yang terkait dengan data ini');
        }
    }

    public function confirm_ajax(string $id)
    {
        $user = UserModel::find($id);

        return view('user.confirm_ajax', ['user' => $user]);
    }

    public function delete_ajax(Request $request, $id)
    {
        if ($request->ajax() || $request->wantsJson()) {
            $user = UserModel::find($id);
            if ($user) {
                try {
                    $user->delete();
                    return response()->json([
                        'status' => true,
                        'message' => 'Data berhasil dihapus'
                    ]);
                } catch (\Illuminate\Database\QueryException $e) {
                    return response()->json([
                        'status' => false,
                        'message' => 'Data tidak bisa dihapus'
                    ]);
                }
            } else {
                return response()->json([
                    'status' => false,
                    'message' => 'Data tidak ditemukan'
                ]);
            }
        }
        return redirect('/');
    }

    public function export_excel()
    {
        // ambil data barang yang akan di export 
        $user = UserModel::select('username', 'nama', 'email', 'no_telepon', 'level_id')
            ->orderBy('username')
            ->with('level')
            ->get();

        // load library excel 
        $spreadsheet = new Spreadsheet();
        $sheet = $spreadsheet->getActiveSheet();        // ambil sheet yang aktif 
        $sheet->setCellValue('A1', 'No');
        $sheet->setCellValue('B1', 'Username');
        $sheet->setCellValue('C1', 'Nama');
        $sheet->setCellValue('D1', 'Email');
        $sheet->setCellValue('E1', 'No Telepon');
        $sheet->setCellValue('F1', 'Level ID');
        $sheet->setCellValue('G1', 'Level');
        $sheet->getStyle('A1:G1')->getFont()->setBold(true);        // bold header

        $no = 1;        // nomor data dimulai dari 1 
        $baris = 2;        // baris data dimulai dari baris ke 2 
        foreach ($user as $key => $value) {
            $sheet->setCellValue('A' . $baris, $no);
            $sheet->setCellValue('B' . $baris, $value->username);
            $sheet->setCellValue('C' . $baris, $value->nama);
            $sheet->setCellValue('D' . $baris, $value->email);
            $sheet->setCellValue('E' . $baris, $value->no_telepon);
            $sheet->setCellValue('F' . $baris, $value->level_id);
            $sheet->setCellValue('G' . $baris, $value->level->level_nama);
            $baris++;
            $no++;
        }

        foreach (range('A', 'G') as $columnID) {
            $sheet->getColumnDimension($columnID)->setAutoSize(true); // set auto size untuk kolom 
        }

        $sheet->setTitle('Data User'); // set title sheet 
        $writer = IOFactory::createWriter($spreadsheet, 'Xlsx');
        $filename = 'Data User ' . date('Y-m-d H:i:s') . '.xlsx';
        header('Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet');
        header('Content-Disposition: attachment;filename="' . $filename . '"');
        header('Cache-Control: max-age=0');
        header('Cache-Control: max-age=1');
        header('Expires: Mon, 26 Jul 1997 05:00:00 GMT');
        header('Last-Modified: ' . gmdate('D, dMY H:i:s') . 'GMT');
        header('Cache-Control: cache, must-revalidate');
        header('Pragma: public');
        $writer->save('php://output');
        exit;
    }
}
