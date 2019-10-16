package com.example.paras.q2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner word;
    TextView output;
    Button translate;
    HashMap<String, String> mapping = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translate = findViewById(R.id.translate);
        output = (TextView) findViewById(R.id.output);
        word = (Spinner) findViewById(R.id.word);

        String[] words = new String[]{"hello","thank you", "welcome"};
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, words);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        word.setAdapter(adapter);

        mapping.put("hello", "Bonjour");
        mapping.put("thank you", "Arigato");
        mapping.put("welcome", "Annagaseyo");

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = word.getSelectedItem().toString().toLowerCase();
                String result = mapping.get(text);
                output.setText(result);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
