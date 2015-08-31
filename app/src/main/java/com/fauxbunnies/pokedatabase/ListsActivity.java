package com.fauxbunnies.pokedatabase;

import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;


/**
 * Created by MacAir on 8/31/15.
 */
public class ListsActivity extends ListActivity {

    ArrayAdapter adapter;
    ArrayList<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        ViewGroup root = (ViewGroup)findViewById(android.R.id.content);
        root.addView(progressBar);

        list = new ArrayList<>();
        for(int i = 0; i < 25; i++) {
            list.add("Item: " + i);

        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }
}
