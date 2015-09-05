package com.fauxbunnies.pokedatabase;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by Miguel on 9/3/2015.
 */
public class ListsFragment extends ListFragment {

    ArrayAdapter adapter;
    ArrayList<String> list;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        /*
        ListsFragment listsFragment= new ListsFragment();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, listsFragment);
        ft.addToBackStack(null);
        ft.commit();
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String[] elements = bundle.getStringArray("Elements");
        list = new ArrayList(elements.length);

        for(int i = 0; i < elements.length; i++){
            list.add(elements[i]);
        }


        adapter = new ArrayAdapter(inflater.getContext(), android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
