package id.co.dev.rabbaanii.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class readdataActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lstDataNya;
    private databaseHandler database;
    private List<modalMahasiswa> lstMhsData = new ArrayList<modalMahasiswa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readdata);

        database = new databaseHandler(this);

        customListAdapter adpList = new customListAdapter(this, lstMhsData);
        lstDataNya = (ListView)findViewById(R.id.listData);
        lstDataNya.setAdapter(adpList);
        lstDataNya.setOnItemClickListener(this);
        lstDataNya.setClickable(true);
        lstMhsData.clear();

        List<modalMahasiswa> kontaknya = database.bacaDataMhs();
        for (modalMahasiswa initKontak : kontaknya){
            modalMahasiswa model = new modalMahasiswa();
            model.setId(initKontak.getId());
            model.setNama(initKontak.getNama());
            model.setKelas(initKontak.getKelas());
            lstMhsData.add(model);

            if ((lstMhsData.isEmpty())){
                Toast.makeText(this, "Tidak ada data!!", Toast.LENGTH_SHORT).show();
            }else {

            }
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Object obj = lstDataNya.getItemAtPosition(i);
        modalMahasiswa obj_itemDetails = (modalMahasiswa)obj;

        String Sid = obj_itemDetails.getId();
        String Snama = obj_itemDetails.getNama();
        String Skelas = obj_itemDetails.getKelas();

        Intent goUpdel = new Intent(readdataActivity.this, updelActivity.class);
        goUpdel.putExtra("ID", Sid);
        goUpdel.putExtra("NAMA", Snama);
        goUpdel.putExtra("KELAS", Skelas);
        startActivity(goUpdel);
    }
}
