package com.example.paras.q2b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Paras on 16-10-2019.
 */

public class CustomAdapter extends ArrayAdapter<Item> {

    private Context context;
    private ArrayList<Item> items;

    public CustomAdapter(Context context, ArrayList<Item> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(final int position, View currentView, ViewGroup viewGroup) {
        View listItem = currentView;
        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.listview_row, viewGroup,false);

        final Item currentItem = items.get(position);

        TextView food = (TextView) listItem.findViewById(R.id.food);
        food.setText(currentItem.getFood());

        TextView price = (TextView) listItem.findViewById(R.id.price);
        price.setText("Rs."+currentItem.getPrice());

        final EditText quantity = (EditText) listItem.findViewById(R.id.qty);
        quantity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                int qty;
                if(!quantity.getText().toString().equals("")) {
                    qty = Integer.parseInt(quantity.getText().toString());
                    currentItem.setQuantity(qty);
                }
            }
        });

        return listItem;
    }
}
