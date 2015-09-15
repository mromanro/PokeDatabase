package com.fauxbunnies.pokedatabase;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
public class CardListFragment extends ListFragment{

    ArrayList<Card> list;
    String setTitle;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putString("Title", list.get(position).title);
        bundle.putString("ImageSource", list.get(position).image);

        CardFragment cardFragment = new CardFragment();
        cardFragment.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, cardFragment);
        ft.addToBackStack("cardList");
        ft.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        int position = bundle.getInt("Position");
        setTitle = bundle.getString("Setlist");

        Element[] elements = XMLParser.getChildElementsByID("set", setTitle);
        list = new ArrayList<>(elements.length);

        for(int i = 0; i < elements.length; i++) {
            list.add(new Card(elements[i].getAttribute("title"),
                              elements[i].getAttribute("img"),
                              elements[i].getAttribute("type")));
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    public void sortListBy(String sortBy) {

    }
}
