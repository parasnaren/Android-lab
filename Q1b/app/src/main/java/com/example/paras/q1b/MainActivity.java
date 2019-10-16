package com.example.paras.q1b;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText m1, m2, m3, maat;
    Double marks1, marks2, marks3;
    TextView total;

    public void calculateTotal() {
        Double min = Math.min(marks1, Math.min(marks2, marks3));
        Double marks_aat = Double.parseDouble(maat.getText().toString());
        Double marks = marks1 + marks2 + marks3 - min + marks_aat;

        total.setText(marks.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1 = (EditText) findViewById(R.id.marks1);
        m2 = (EditText) findViewById(R.id.marks2);
        m3 = (EditText) findViewById(R.id.marks3);
        maat = (EditText) findViewById(R.id.marks_aat);
        total = (TextView) findViewById(R.id.actual_total);

        marks1 = Double.parseDouble(m1.getText().toString());
        marks2 = Double.parseDouble(m2.getText().toString());
        marks3 = Double.parseDouble(m3.getText().toString());

        m1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                marks1 = Double.parseDouble(m1.getText().toString());
                if (marks1 < 20)
                    m1.setTextColor(Color.RED);
                else
                    m1.setTextColor(Color.GREEN);
                calculateTotal();
            }
        });
        m2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                marks2 = Double.parseDouble(m2.getText().toString());
                if (marks2 < 20)
                    m2.setTextColor(Color.RED);
                else
                    m2.setTextColor(Color.GREEN);
                calculateTotal();
            }
        });
        m3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                marks3 = Double.parseDouble(m3.getText().toString());
                if (marks3 < 20)
                    m3.setTextColor(Color.RED);
                else
                    m3.setTextColor(Color.GREEN);
                calculateTotal();
            }


        });
    }
}