package id.co.dev.rabbaanii.sqlitedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCreate(View view){
        Intent goCreate = new Intent(mainActivity.this, createdataActivity.class);
        startActivity(goCreate);
    }

    public void tbnRead(View view){
        Intent goCreate = new Intent(mainActivity.this, readdataActivity.class);
        startActivity(goCreate);
    }
}
