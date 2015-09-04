package com.fauxbunnies.pokedatabase;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Miguel on 9/3/2015.
 */
public class ListsFragment extends ListFragment {

    ArrayAdapter adapter;
    ArrayList<String> list;
    int size = 0;

    public ListsFragment (int size) {
        this.size = size;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ListsFragment listsFragment= new ListsFragment(5);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, listsFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        list = new ArrayList<>(size);
        for(int i = 0; i < size; i++) {
            list.add("Item: " + i);
        }

        adapter = new ArrayAdapter(inflater.getContext(), android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container, savedInstanceState);
    }
}
