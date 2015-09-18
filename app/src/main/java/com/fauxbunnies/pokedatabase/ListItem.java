package com.fauxbunnies.pokedatabase;

/**
 * Created by Miguel on 9/12/2015.
 */
public class ListItem {

    public String imageSrc = "Pokemon/Colorless-attack.png";
    public String title;

    public ListItem(String title) {
        this.title = title;
    }

    public ListItem(String title, String imageSrc) {
        this.imageSrc = imageSrc;
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
