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

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by MacAir on 9/6/15.
 */
public class SetListFragment extends ListFragment {

    ArrayList<ListItem> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);
        bundle.putString("Setlist", list.get(position).title);

        Manager.SET_POSITION = position;

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

        Element[] elements = XMLParser.getChildElementsByPosition("group", position);

        list = new ArrayList<>(elements.length);

        for(int i = 0; i < elements.length; i++) {
            list.add(new ListItem(elements[i].getAttribute("title"),
                                  elements[i].getAttribute("img")));
        }

        CustomAdapter adapter = new CustomAdapter(inflater.getContext(), R.layout.poke_list_item_1,
                list);
        setListAdapter(adapter);

        /*
        ArrayAdapter adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);
        */

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

