package com.example.paras.q3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

public class SearchViewHandler extends AppCompatActivity implements SearchView.OnQueryTextListener {
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchview_activity);

        listView = (ListView) findViewById(R.id.lv1);

        list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("pineapple");
        list.add("orange");
        list.add("lychee");
        list.add("guava");
        list.add("peach");
        list.add("melon");
        list.add("watermelon");
        list.add("papaya");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if(!list.contains(query)) {
            Toast.makeText(SearchViewHandler.this, "No Match found", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}

