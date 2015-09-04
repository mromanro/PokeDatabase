package com.fauxbunnies.pokedatabase;

import java.util.ArrayList;

/**
 * Created by MacAir on 9/4/15.
 */
public class Manager {

    public static ArrayList<String> groups;
    public static ArrayList<String> sets;

    public static void initialize() {
        groups = new ArrayList();
        sets = new ArrayList();
    }
}
