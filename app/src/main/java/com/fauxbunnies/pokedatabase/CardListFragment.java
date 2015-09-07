package com.fauxbunnies.pokedatabase;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MacAir on 9/6/15.
 */
public class CardListFragment extends ListFragment{

    ArrayList<String> list;
    String setTitle;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        int position = bundle.getInt("Position");
        setTitle = bundle.getString("Setlist");

        String[] elements = XMLParser.getChildElementsByID("set", setTitle);

        list = new ArrayList<>(elements.length);
        list.addAll(Arrays.asList(elements));

        ArrayAdapter adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
