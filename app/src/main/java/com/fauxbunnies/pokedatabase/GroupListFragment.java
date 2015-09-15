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
 * Created by Miguel on 9/3/2015.
 */
public class GroupListFragment extends ListFragment {

    ArrayList<String> list;

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);

        Manager.GROUP_POSITION = position;


        SetListFragment setListFragment = new SetListFragment();
        setListFragment.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, setListFragment);
        ft.addToBackStack("group");
        ft.commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] elements = XMLParser.getElementsByTagName("group");

        list = new ArrayList<>(elements.length);
        list.addAll(Arrays.asList(elements));

        ArrayAdapter adapter = new ArrayAdapter<>(inflater.getContext(),
                                                android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter);

        return super.onCreateView(inflater,container, savedInstanceState);
    }

}