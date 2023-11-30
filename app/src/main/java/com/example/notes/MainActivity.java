package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    public static final String DATA = "DATA";

    private SharedPreferences prefs;;
    private SharedPreferences.Editor editor;

    TextView textView;
    List<String> toDolist;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    EditText editText;
    private Button add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.btn);


        toDolist = new Vector<>();
        arrayAdapter = new ArrayAdapter<>(this,R.layout.list_view_layout, toDolist);
        listView = findViewById(R.id.list_view);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setPaintFlags(textView.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
        editText = findViewById(R.id.id_edit_text);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });
    }



    public void addItemToList(View view) {
        toDolist.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");

//
//        Gson gson = new Gson();
//        String str = prefs.getString(DATA, "");
    }

        public void bcheck(View view) {
            Gson gson = new Gson();
            String str = prefs.getString(DATA, "");

            //prefs = PreferenceManager.getDefaultSharedPreferences(this);
            editor = prefs.edit();


        }





//        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(this,
//                android.R.layout.simple_list_item_1,
//                Drink.drinks);
//
//        ListView listView = (ListView)findViewById(R.id.drinks_list);
//        listView.setAdapter(listAdapter);





}