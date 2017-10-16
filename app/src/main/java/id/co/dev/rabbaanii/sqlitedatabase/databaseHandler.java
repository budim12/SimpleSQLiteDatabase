package id.co.dev.rabbaanii.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moeslim on 16/10/17.
 */

public class databaseHandler extends SQLiteOpenHelper{

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_kampus";

    private static final String tbl_mahasiswa = "tbl_dataMHS";
    private static final String tbl_mhs_id = "id";
    private static final String tbl_mhs_nama = "name";
    private static final String tbl_mhs_kelas = "kelas";

    private static final String queryCREATETABLE = "CREATE TABLE " + tbl_mahasiswa + "(" + tbl_mhs_id + " INTEGER PRIMARY KEY," + tbl_mhs_nama + " TEXT," + tbl_mhs_kelas + " TEXT" + ")";


    public databaseHandler (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(queryCREATETABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public void createMahasiswa(modalMahasiswa mdNotif){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(tbl_mhs_id, mdNotif.getId());
        values.put(tbl_mhs_nama, mdNotif.getNama());
        values.put(tbl_mhs_kelas, mdNotif.getKelas());

        database.insert(tbl_mahasiswa, null, values);
        database.close();
    }

    public List<modalMahasiswa> bacaDataMhs(){
        List<modalMahasiswa> list = new ArrayList<modalMahasiswa>();
        String selectQuery = "SELECT * from " + tbl_mahasiswa;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                modalMahasiswa mdContact = new modalMahasiswa();
                mdContact.setId(cursor.getString(0));
                mdContact.setNama(cursor.getString(1));
                mdContact.setKelas(cursor.getString(2));
                list.add(mdContact);
            }while (cursor.moveToNext());
        }
        database.close();
        return list;
    }

    public int updateDataMahasiswa(modalMahasiswa mdNotif){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tbl_mhs_nama, mdNotif.getNama());
        values.put(tbl_mhs_kelas, mdNotif.getKelas());

        return database.update(tbl_mahasiswa, values, tbl_mhs_id + " = ?", new String[] { String.valueOf(mdNotif.getId())});
    }

    public void deteleDataMahasiswa(modalMahasiswa mdNotif){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(tbl_mahasiswa, tbl_mhs_id + " = ?", new String[]{String.valueOf(mdNotif.getId())});
        database.close();
    }
}
