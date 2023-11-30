package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    private TextView txtShowTasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        txtShowTasks = findViewById(R.id.txtShowTasks);
        String msg = intent.getStringExtra("data");
        txtShowTasks.setText(msg);

    }
}