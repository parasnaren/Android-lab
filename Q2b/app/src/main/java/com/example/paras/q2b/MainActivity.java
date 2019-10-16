package com.example.paras.q2b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new Item("Pizza", "350"));
        items.add(new Item("Pasta", "200"));
        items.add(new Item("Burger", "300"));
        items.add(new Item("Ice cream", "120"));

        CustomAdapter adapter = new CustomAdapter(this, items);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        final TextView finalTotal = (TextView) findViewById(R.id.total);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total = 0;
                for(Item item: items) {
                    total += item.getQuantity() * Integer.parseInt(item.getPrice());
                }
                finalTotal.setText(String.valueOf(total));
            }
        });
    }
}
