package com.fauxbunnies.pokedatabase;

import android.content.Context;
import android.os.Bundle;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by MacAir on 9/4/15.
 */
public class Manager {

    public static ArrayList<String> groups;
    public static ArrayList<String> sets;
    private Context context;
    private static Manager MANAGER;
    public static int GROUP_POSITION = 0;
    public static int SET_POSITION = 0;

    private Manager() {

    }

    public static Manager getInstance() {
        if (MANAGER == null) {
            MANAGER = new Manager();
        }

        return MANAGER;
    }

    public void initialize(Context context) {
        groups = new ArrayList();
        sets = new ArrayList();
        this.context = context;

        InputStream is = context.getResources().openRawResource(R.raw.cards);
    }


    public Bundle createBundle(String[] elements) {
        Bundle bundle = new Bundle();
        bundle.putStringArray("Elements", elements);

        return bundle;
    }

}
