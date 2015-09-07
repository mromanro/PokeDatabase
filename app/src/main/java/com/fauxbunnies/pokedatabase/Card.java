package com.fauxbunnies.pokedatabase;

import android.media.Image;

/**
 * Created by MacAir on 9/6/15.
 */
public class Card {

    public String title;
    public String image;

    public Card(String title, String image) {
        this.title = title;
        this.image = image;
    }

    @Override
    public String toString() {
        return title;
    }
}
