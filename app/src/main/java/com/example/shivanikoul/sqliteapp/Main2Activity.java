package com.example.shivanikoul.sqliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button showdetail;



            showdetail = findViewById(R.id.showdetail);

            showdetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main2Activity.this, "data has been submited successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Main2Activity.this,Main5Activity.class);
                    startActivity(intent);
                }
            });

        }
}
