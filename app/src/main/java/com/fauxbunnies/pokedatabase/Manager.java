package com.fauxbunnies.pokedatabase;

import android.content.Context;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by MacAir on 9/4/15.
 */
public class Manager {

    public static ArrayList<String> groups;
    public static ArrayList<String> sets;
    private Context context;

    public void initialize(Context context) {
        groups = new ArrayList();
        sets = new ArrayList();
        this.context = context;

        InputStream is = context.getResources().openRawResource(R.raw.cards);
    }




}
