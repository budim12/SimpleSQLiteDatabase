package id.co.dev.rabbaanii.sqlitedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updelActivity extends AppCompatActivity {

    private databaseHandler database;
    private String Sid, Snama, Skelas;
    private EditText Ednama, Edkelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);


        database = new databaseHandler(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("ID");
        Snama = i.getStringExtra("NAMA");
        Skelas = i.getStringExtra("KELAS");

        Ednama = (EditText)findViewById(R.id.edNama);
        Edkelas = (EditText)findViewById(R.id.edKelas);

        Ednama.setText(Snama);
        Edkelas.setText(Skelas);

        Button btnUpd = (Button)findViewById(R.id.btnUpdate);
        Button btnDel = (Button)findViewById(R.id.btnDel);

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Ednama.getText());
                Skelas = String.valueOf(Edkelas.getText());

                if(Snama.equals("")){
                    Ednama.requestFocus();
                    Toast.makeText(updelActivity.this, "Silahkan isi nama...", Toast.LENGTH_SHORT).show();
                }else if (Skelas.equals("")){
                    Edkelas.requestFocus();
                    Toast.makeText(updelActivity.this, "Silahkan isi kelas...", Toast.LENGTH_SHORT).show();
                }else {
                    database.updateDataMahasiswa(new modalMahasiswa(Sid, Snama, Skelas));
                    Toast.makeText(updelActivity.this, "Data sudah di perbaharui...", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.deteleDataMahasiswa(new modalMahasiswa(Sid, Snama, Skelas));
                Toast.makeText(updelActivity.this, "Data sudah di hapus.....", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
