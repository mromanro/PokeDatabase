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
import java.util.Arrays;

/**
 * Created by MacAir on 9/6/15.
 */
public class SetListFragment extends ListFragment {

    ArrayList<String> list;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);

        CardListFragment cardListFragment = new CardListFragment();
        cardListFragment.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, cardListFragment);
        ft.addToBackStack("set");
        ft.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        int position = bundle.getInt("Position");

        String[] elements = XMLParser.getChildElements("group", position);

        list = new ArrayList<>(elements.length);
        list.addAll(Arrays.asList(elements));


        ArrayAdapter adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
