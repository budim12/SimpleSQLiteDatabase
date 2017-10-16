package id.co.dev.rabbaanii.sqlitedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createdataActivity extends AppCompatActivity {

    private databaseHandler dbMhs;
    private EditText Enama, Ekelas;
    private String Snama, Skelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdata);

        dbMhs = new databaseHandler(this);
        Enama = (EditText)findViewById(R.id.create_nama);
        Ekelas = (EditText)findViewById(R.id.create_kelas);
        Button btnCreate = (Button)findViewById(R.id.createBtn);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skelas = String.valueOf(Ekelas.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(createdataActivity.this, "Silahkan isi Nama dulu!!", Toast.LENGTH_SHORT).show();
                }else if (Skelas.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(createdataActivity.this, "Silahkan isi Kelas dulu!!", Toast.LENGTH_SHORT).show();
                }else {
                    Enama.setText("");
                    Ekelas.setText("");
                    Toast.makeText(createdataActivity.this, "Data telah ditambahkan", Toast.LENGTH_SHORT).show();
                    dbMhs.createMahasiswa(new modalMahasiswa(null, Snama, Skelas));
                }
            }
        });
    }
}
