package com.fauxbunnies.pokedatabase;

import android.media.Image;

/**
 * Created by MacAir on 9/6/15.
 */
public class Card extends ListItem{

    public String image;
    public String type;

    public Card(String title, String image) {
        super(null, title);
        this.image = image;
    }

    public Card(String title, String image, String type) {
        super(null, title);
        this.image = image;
        this.type = type;
    }

    public Card(String title, String image, String type, String typeImage) {
        super(typeImage, title);
        this.image = image;
        this.type = type;
    }


    @Override
    public String toString() {
        return title;
    }
}
